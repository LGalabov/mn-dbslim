package com.example.repository;

import com.example.repository.entity.TodoEntity;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface TodoRepository extends CrudRepository<TodoEntity, Integer> {
}
