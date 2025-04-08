package com.nga.structura.controller.dictionary;

import com.nga.structura.model.dictionary.TaskStatus;
import com.nga.structura.service.dictionary.TaskStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary/task-status")
public class TaskStatusController extends DictionaryController<TaskStatus> {
    public TaskStatusController(TaskStatusService service) {
        super(service);
    }
}