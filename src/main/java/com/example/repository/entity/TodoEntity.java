package com.example.repository.entity;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import java.time.LocalDateTime;

@MappedEntity("todo")
public record TodoEntity(
        @Id @GeneratedValue Integer id,
        String note,
        @DateCreated LocalDateTime date) {

    public TodoEntity(String note) {
        this(null, note, null);
    }
}
