package com.nga.structura.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToMany(mappedBy = "users")
    private List<Project> projects;

    @OneToMany(mappedBy = "assignedUser")
    private List<Task> tasks;
}