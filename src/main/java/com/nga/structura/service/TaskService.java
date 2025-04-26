package com.nga.structura.service;

import com.nga.structura.dto.project.CreateProjectDTO;
import com.nga.structura.dto.project.GetProjectDTO;
import com.nga.structura.dto.task.CreateTaskDTO;
import com.nga.structura.dto.task.GetTaskDTO;
import com.nga.structura.dto.task.UpdateTaskDTO;
import com.nga.structura.model.Project;
import com.nga.structura.model.Task;
import com.nga.structura.model.User;
import com.nga.structura.model.dictionary.Priority;
import com.nga.structura.model.dictionary.TaskStatus;
import com.nga.structura.model.dictionary.TaskType;
import com.nga.structura.repository.ProjectRepository;
import com.nga.structura.repository.TaskRepository;
import com.nga.structura.repository.UserRepository;
import com.nga.structura.repository.dictionary.PriorityRepository;
import com.nga.structura.repository.dictionary.TaskStatusRepository;
import com.nga.structura.repository.dictionary.TaskTypeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskService {

    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private final TaskTypeRepository taskTypeRepository;
    private final TaskStatusRepository taskStatusRepository;
    private final PriorityRepository priorityRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    private GetTaskDTO convertToGetDTO (Task task) {
        return modelMapper.map(task,GetTaskDTO.class);
    }

    public Optional<GetTaskDTO> getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(this::convertToGetDTO);
    }

    public Page<GetTaskDTO> getAllTasks(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size); // Пагинация с учетом того, что страницы начинаются с 0
        Page<Task> taskPage = taskRepository.findAll(pageable); // Запрос с пагинацией
        return taskPage.map(this::convertToGetDTO); // Конвертация в DTO
    }

    public GetTaskDTO createTask(CreateTaskDTO createTaskDTO) {
        Task task = modelMapper.map(createTaskDTO, Task.class);
        TaskType taskType = taskTypeRepository.findById(String.valueOf(createTaskDTO.getTaskType()))
                .orElseThrow(() -> new RuntimeException("Task type not found"));
        task.setTaskType(taskType);
        User taskAssigner = userRepository.findById(createTaskDTO.getAssignedUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        task.setAssignedUser(taskAssigner);
        TaskStatus status = taskStatusRepository.findById("1")
                .orElseThrow(() -> new RuntimeException("Task status not found"));
        task.setTaskStatus(status);
        Project project = projectRepository.findById(createTaskDTO.getProjectId())
                        .orElseThrow(()-> new RuntimeException("Project not found"));
        task.setProject(project);
        Priority priority = priorityRepository.findById(String.valueOf(createTaskDTO.getPriority()))
                        .orElseThrow(() -> new RuntimeException("Priority not found"));
        task.setStartDate(LocalDate.now());
        task.setPriority(priority);
        Long savedTask = taskRepository.save(task).getId();
        Task loadedTask = taskRepository.findById(savedTask).orElseThrow(()-> new RuntimeException("Task not found"));
        return convertToGetDTO(loadedTask);
    }

    public GetTaskDTO updateTask(UpdateTaskDTO updateTaskDTO, Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task doesn't exist"));
        if (updateTaskDTO.getTaskStatusID()!= null) {
            TaskStatus taskStatus = taskStatusRepository.findById(updateTaskDTO.getTaskStatusID().toString())
                            .orElseThrow(() -> new RuntimeException("Task status not found"));
            task.setTaskStatus(taskStatus);
        }
        if (updateTaskDTO.getAssignedUserID()!= null) {
            User user = userRepository.findById(updateTaskDTO.getAssignedUserID())
                    .orElseThrow(()-> new RuntimeException("User not found"));
            task.setAssignedUser(user);
        }
        if (updateTaskDTO.getPriorityID()!= null) {
            Priority priority = priorityRepository.findById(updateTaskDTO.getPriorityID().toString())
                    .orElseThrow(() -> new RuntimeException("Priority not found"));
            task.setPriority(priority);
        }
        if (updateTaskDTO.getDescription()!= null) task.setDescription(updateTaskDTO.getDescription());
        if (updateTaskDTO.getName()!= null) task.setName(updateTaskDTO.getName());
        if (updateTaskDTO.getDueDate()!= null) task.setDueDate(updateTaskDTO.getDueDate());
        Task savedTask = taskRepository.save(task);
        return convertToGetDTO(savedTask);
    }

    public Page<GetTaskDTO> searchTasks(Long taskStatusId, Long userId, Long taskTypeId, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size); // page - 1, так как страницы начинаются с 0
        if (taskStatusId != null && userId != null && taskTypeId != null) {
            return taskRepository.findByTaskStatusIdAndAssignedUserIdAndTaskTypeId(taskStatusId, userId, taskTypeId, pageable)
                    .map(this::convertToGetDTO);
        } else if (taskStatusId != null && userId != null) {
            return taskRepository.findByTaskStatusIdAndAssignedUserId(taskStatusId, userId, pageable)
                    .map(this::convertToGetDTO);
        } else if (taskStatusId != null && taskTypeId != null) {
            return taskRepository.findByTaskStatusIdAndTaskTypeId(taskStatusId, taskTypeId, pageable)
                    .map(this::convertToGetDTO);
        } else if (userId != null && taskTypeId != null) {
            return taskRepository.findByAssignedUserIdAndTaskTypeId(userId, taskTypeId, pageable)
                    .map(this::convertToGetDTO);
        } else if (taskStatusId != null) {
            return taskRepository.findByTaskStatusId(taskStatusId, pageable)
                    .map(this::convertToGetDTO);
        } else if (userId != null) {
            return taskRepository.findByAssignedUserId(userId, pageable)
                    .map(this::convertToGetDTO);
        } else if (taskTypeId != null) {
            return taskRepository.findByTaskTypeId(taskTypeId, pageable)
                    .map(this::convertToGetDTO);
        } else {
            return taskRepository.findAll(pageable)
                    .map(this::convertToGetDTO); // Пагинация по всем задачам
        }
    }
}
