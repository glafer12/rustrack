package com.nga.structura.dto.task;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskDTO {

    @NotBlank(message = "Название обязательно")
    private String name;
    @NotBlank(message = "Тип обязательно")
    private Integer taskType;
    @NotBlank(message = "Описание обязательно")
    private String description;
    @NotBlank(message = "Приоритет обязательно")
    private Integer priority;
    @NotBlank(message = "Срок выполнения обязательно")
    private LocalDate dueDate;
    @NotBlank(message = "Пользователь обязательно")
    private Long assignedUserId;
    @NotBlank(message = "Проект обязательно")
    private Long projectId;

}
