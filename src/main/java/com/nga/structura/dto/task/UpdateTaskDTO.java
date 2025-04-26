package com.nga.structura.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskDTO {

    private String name;
    private Integer taskStatusID;
    private String description;
    private Integer priorityID;
    private LocalDate dueDate;
    private Long assignedUserID;

}
