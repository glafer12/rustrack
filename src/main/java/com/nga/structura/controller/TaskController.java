package com.nga.structura.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.nga.structura.model.Project;
import com.nga.structura.model.Task;
import com.nga.structura.service.TaskService;
import com.nga.structura.views.Views;
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

    @JsonView(Views.GetResponse.class)
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @JsonView(Views.GetResponse.class)
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

}
