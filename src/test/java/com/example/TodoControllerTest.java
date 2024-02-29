package com.example;

import com.example.config.Environment;
import com.example.controller.model.TodoDto;
import com.example.repository.TodoRepository;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest(environments = Environment.API_MODE)
class TodoControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(TodoControllerTest.class);

    @Inject
    @Client("/todos")
    HttpClient client;

    @Inject
    TodoRepository todoRepository;

    @BeforeEach
    public void clean() {
        todoRepository.deleteAll();
    }

    @Test
    void returnsAllTodos() {
        List<TodoDto> response = client.toBlocking()
                .retrieve(HttpRequest.GET("/"), Argument.listOf(TodoDto.class));
        assertTrue(response.isEmpty());
    }

    @Test
    void insertsRandomTodo() {
        TodoDto response = client.toBlocking()
                .retrieve(HttpRequest.GET("/new"), Argument.of(TodoDto.class));

        logger.info("Response: {}", response);
        assertEquals(1, todoRepository.findAll().size());
    }
}
