package com.nga.structura.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectDTO {

    @NotBlank(message = "Наиманование обязательно")
    private String name;
    @NotBlank(message = "Ключ обязателен")
    private String key;
    @NotBlank(message = "Описание обязательно")
    private String description;
    @NotNull(message = "ID лидера проекта обязателен")
    private Long projectLeaderId;

}
