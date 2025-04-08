package com.nga.structura.controller.dictionary;

import com.nga.structura.model.dictionary.TaskType;
import com.nga.structura.service.dictionary.DictionaryService;
import com.nga.structura.service.dictionary.TaskTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary/task-type")
public class TaskTypeController extends DictionaryController<TaskType>{
    public TaskTypeController(TaskTypeService service) {
        super(service);
    }
}
