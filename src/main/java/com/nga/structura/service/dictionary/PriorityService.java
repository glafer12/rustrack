package com.nga.structura.service.dictionary;

import com.nga.structura.model.dictionary.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PriorityService extends DictionaryService<Priority> {
    public PriorityService(JpaRepository<Priority, ?> repository) {
        super(repository);
    }
}
