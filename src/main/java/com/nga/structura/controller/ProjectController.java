package com.nga.structura.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.nga.structura.model.Project;
import com.nga.structura.service.ProjectService;
import com.nga.structura.views.Views;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @JsonView(Views.GetResponse.class)
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @JsonView(Views.GetResponse.class)
    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }
}