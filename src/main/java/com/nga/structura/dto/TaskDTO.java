package com.nga.structura.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.nga.structura.model.Project;
import com.nga.structura.model.User;
import com.nga.structura.model.dictionary.Priority;
import com.nga.structura.model.dictionary.TaskStatus;
import com.nga.structura.model.dictionary.TaskType;
import com.nga.structura.views.Views;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Long id;
    private TaskType taskType;
    private String name;
    private String description;
    private Priority priority;
    private LocalDate dueDate;
    private Project project_id;
    private User assignedUser;

}
