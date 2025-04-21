package com.nga.structura.service;

import com.nga.structura.dto.CreateProjectDTO;
import com.nga.structura.dto.GetProjectDTO;
import com.nga.structura.model.Project;
import com.nga.structura.model.User;
import com.nga.structura.model.dictionary.TaskStatus;
import com.nga.structura.repository.ProjectRepository;
import com.nga.structura.repository.UserRepository;
import com.nga.structura.repository.dictionary.TaskStatusRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final TaskStatusRepository taskStatusRepository;

    private GetProjectDTO convertToGetDTO (Project project) {
        return modelMapper.map(project,GetProjectDTO.class);
    }

    private CreateProjectDTO convertToPostDTO (Project project) {
        return modelMapper.map(project,CreateProjectDTO.class);
    }

    public List<GetProjectDTO> getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        return projectList.stream()
                .map(this::convertToGetDTO)
                .collect(Collectors.toList());
    }

    public Optional<GetProjectDTO> getProjectById(Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        return projectOptional.map(this::convertToGetDTO);
    }

    public GetProjectDTO createProject(CreateProjectDTO createProjectDTO) {
        Project project = modelMapper.map(createProjectDTO, Project.class);
        String statusId = "1";
        TaskStatus status = taskStatusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Task status not found"));
        project.setStatus(status);
        User leader = userRepository.findById(createProjectDTO.getProjectLeaderId())
                .orElseThrow(() -> new RuntimeException("Project leader not found"));
        project.setProjectLeader(leader);
        project.setStartDate(LocalDate.now());
        project.setEndDate(LocalDate.of(5999,12,31));
        Project savedProject = projectRepository.save(project);
        return convertToGetDTO(savedProject);
    }
}