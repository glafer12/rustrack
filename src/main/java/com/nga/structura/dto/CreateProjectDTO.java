package com.nga.structura.dto;

import com.nga.structura.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectDTO {

    @NotBlank(message = "Описание обязательно")
    private String name;
    @NotBlank(message = "Описание обязательно")
    private String key;
    @NotBlank(message = "Описание обязательно")
    private String description;
    @NotNull(message = "ID лидера проекта обязателен")
    private Long projectLeaderId;

}
