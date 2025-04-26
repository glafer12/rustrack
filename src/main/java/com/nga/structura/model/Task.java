package com.nga.structura.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nga.structura.dto.task.GetTaskDTO;
import com.nga.structura.model.dictionary.Priority;
import com.nga.structura.model.dictionary.TaskStatus;
import com.nga.structura.model.dictionary.TaskType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_type_id")
    private TaskType taskType;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "task_status_id")
    private TaskStatus taskStatus;

    private LocalDate startDate;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;

}