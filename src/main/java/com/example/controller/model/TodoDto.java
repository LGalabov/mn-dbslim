package com.example.controller.model;

import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDateTime;

@Serdeable
public record TodoDto(
        String note,
        LocalDateTime date) {
}
