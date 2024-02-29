package com.example.controller;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Set;

@Controller("/system")
public class SystemController {
    private final ApplicationContext context;

    public SystemController(ApplicationContext context) {
        this.context = context;
    }

    @Get("/environments")
    public Set<String> getEnvironments() {
        return context.getEnvironment().getActiveNames();
    }
}
