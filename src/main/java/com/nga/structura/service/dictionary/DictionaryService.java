package com.nga.structura.service.dictionary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class DictionaryService<T> {

    private final JpaRepository<T, ?> repository;

    protected DictionaryService(JpaRepository<T, ?> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

}