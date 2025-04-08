package com.nga.structura.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nga.structura.model.User;
import jakarta.persistence.*;

import java.time.LocalDate;

public class ProjectDTO {

    private Long id;
    private String name;
    private String description;

    @JsonManagedReference
    private User projectLeader;

}
