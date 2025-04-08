package com.nga.structura.controller.dictionary;

import com.nga.structura.model.dictionary.Priority;
import com.nga.structura.service.dictionary.DictionaryService;
import com.nga.structura.service.dictionary.PriorityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary/priority")
public class PriorityController extends DictionaryController<Priority> {
    public PriorityController(PriorityService service) {
        super(service);
    }
}
