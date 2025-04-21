package com.nga.structura.model;


import com.nga.structura.model.dictionary.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @Pattern(
            regexp = "^[A-Z]{3,5}$",
            message = "Ключ должен содержать только заглавные английские буквы (от 3 до 5 символов)")
    private String key;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id")
    private TaskStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "project_leader_id",referencedColumnName = "id")
    private User projectLeader;

}