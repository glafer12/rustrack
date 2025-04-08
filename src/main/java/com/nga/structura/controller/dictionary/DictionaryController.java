package com.nga.structura.controller.dictionary;

import com.nga.structura.service.dictionary.DictionaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class DictionaryController<T> {

    private final DictionaryService<T> service;

    protected DictionaryController(DictionaryService<T> service) {
        this.service = service;
    }

    @GetMapping
    public List<T> getAll() {
        return service.findAll();
    }

}