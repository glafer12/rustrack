package com.nga.structura.config;

import com.nga.structura.dto.project.GetProjectDTO;
import com.nga.structura.dto.task.CreateTaskDTO;
import com.nga.structura.dto.task.GetTaskDTO;
import com.nga.structura.model.Project;
import com.nga.structura.model.Task;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addMappings(new PropertyMap<CreateTaskDTO, Task>() {
            @Override
            protected void configure() {
                skip(destination.getTaskType());
            }
        });

        modelMapper.addMappings(new PropertyMap<Task, CreateTaskDTO>() {
            @Override
            protected void configure() {
                skip(destination.getTaskType());
            }
        });

        modelMapper.addMappings(new PropertyMap<Task, GetTaskDTO>() {
            @Override
            protected void configure() {
                map(source.getTaskType().getId(), destination.getTaskTypeID());
                map(source.getTaskStatus().getId(), destination.getTaskStatusID());
                map(source.getPriority().getId(), destination.getPriorityID());
                map(source.getAssignedUser().getId(), destination.getAssignedUserID());
                map(source.getProject().getId(), destination.getProjectId());
            }
        });

        modelMapper.addMappings(new PropertyMap<Project, GetProjectDTO>() {
            @Override
            protected void configure() {
                map(source.getStatus().getId(), destination.getStatusId());
                map(source.getProjectLeader().getId(), destination.getProjectLeaderId());
            }
        });

        return modelMapper;
    }
}