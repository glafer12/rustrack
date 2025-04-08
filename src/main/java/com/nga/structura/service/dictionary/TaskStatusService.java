package com.nga.structura.service.dictionary;

import com.nga.structura.model.dictionary.TaskStatus;
import com.nga.structura.repository.dictionary.TaskStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskStatusService extends DictionaryService<TaskStatus> {
    public TaskStatusService(TaskStatusRepository repository) {
        super(repository);
    }
}