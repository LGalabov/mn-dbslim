package com.example.mapper;

import com.example.controller.model.TodoDto;
import com.example.repository.entity.TodoEntity;
import io.micronaut.context.annotation.Mapper;
import jakarta.inject.Singleton;

@Singleton
public interface TodoMapper {
    @Mapper
    TodoDto toDto(TodoEntity entity);
}
