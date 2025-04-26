package com.nga.structura.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.nga.structura.dto.task.CreateTaskDTO;
import com.nga.structura.dto.task.GetTaskDTO;
import com.nga.structura.dto.task.UpdateTaskDTO;
import com.nga.structura.model.Project;
import com.nga.structura.model.Task;
import com.nga.structura.service.TaskService;
import com.nga.structura.views.Views;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Page<GetTaskDTO> getAllTasks(
            @RequestParam(defaultValue = "1") int page,  // Default page is 1
            @RequestParam(defaultValue = "10") int size) {  // Default size is 10
        return taskService.getAllTasks(page, size);
    }

    @GetMapping("/{id}")
    public GetTaskDTO getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @PostMapping
    public GetTaskDTO createTask(@RequestBody CreateTaskDTO createTaskDTO) {
        return taskService.createTask(createTaskDTO);
    }

    @PatchMapping("/{id}")
    public GetTaskDTO updateTask(@RequestBody UpdateTaskDTO updateTaskDTO, @PathVariable Long id) {
        return taskService.updateTask(updateTaskDTO, id);
    }

    @GetMapping("/search")
    public Page<GetTaskDTO> searchTasks(
            @RequestParam(required = false) Long taskStatusId,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long taskTypeId,
            @RequestParam(defaultValue = "1") int page,  // Default page is 1
            @RequestParam(defaultValue = "10") int size) {  // Default size is 10
        return taskService.searchTasks(taskStatusId, userId, taskTypeId, page, size);
    }

}
