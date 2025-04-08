package com.nga.structura.service.dictionary;

import com.nga.structura.model.dictionary.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeService extends DictionaryService<TaskType> {
    protected TaskTypeService(JpaRepository<TaskType, ?> repository) {
        super(repository);
    }
}
