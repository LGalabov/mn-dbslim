package com.example.controller;

import com.example.config.Environment;
import com.example.controller.model.TodoDto;
import com.example.mapper.TodoMapper;
import com.example.service.TodoService;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.util.List;

@Controller("/todos")
@Requires(env = Environment.API_MODE)
@ExecuteOn(TaskExecutors.BLOCKING)
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @Get
    public List<TodoDto> getAll() {
        return todoService.getAll().stream()
                .map(todoMapper::toDto).toList();
    }

    @Get("/new")
    public TodoDto insertRandom() {
        var todo = todoService.insertRandom();
        return todoMapper.toDto(todo);
    }
}
