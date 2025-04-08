package com.nga.structura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user_in_project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Long projectId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Long userId;

    private String roleInProject;

}
