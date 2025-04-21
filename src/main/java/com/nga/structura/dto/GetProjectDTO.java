package com.nga.structura.dto;

import com.nga.structura.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GetProjectDTO {

    private Long id;
    private String key;
    private String name;
    private String description;
    private Integer status;
    private LocalDate startDate;
    private LocalDate endDate;
    private User projectLeader;

}
