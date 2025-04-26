package com.nga.structura.dto.task;

import com.nga.structura.model.Project;
import com.nga.structura.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetTaskDTO {

    private Long id;
    private String name;
    private Integer taskTypeID;
    private Integer taskStatusID;
    private String description;
    private Integer priorityID;
    private LocalDate startDate;
    private LocalDate dueDate;
    private Long assignedUserID;
    private Long projectId;

}
