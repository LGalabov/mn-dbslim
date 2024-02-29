package com.example.service;

import com.example.config.ApplicationConfig;
import com.example.repository.TodoRepository;
import com.example.repository.entity.TodoEntity;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Random;

@Singleton
public class TodoService {
    private final Random random = new Random();
    private final TodoRepository todoRepository;
    private final ApplicationConfig config;

    public TodoService(TodoRepository todoRepository, ApplicationConfig config) {
        this.todoRepository = todoRepository;
        this.config = config;
    }

    public List<TodoEntity> getAll() {
        return todoRepository.findAll();
    }

    public TodoEntity insertRandom() {
        var index = random.nextInt(config.getLoremSentences().size());
        var note = config.getLoremSentences().get(index);
        return todoRepository.save(new TodoEntity(note));
    }
}
