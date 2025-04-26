package com.nga.structura.dto.project;

import com.nga.structura.model.User;
import com.nga.structura.model.dictionary.TaskStatus;
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
    private Long statusId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long projectLeaderId;

}
