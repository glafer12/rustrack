package com.nga.structura.model.dictionary;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public interface DictionaryEntity {

    String getCode();
    String getDescription();
}