package com.example;

import com.example.config.Environment;
import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest(environments = Environment.API_MODE)
public class ConfigurationTest {

    @Inject
    ApplicationContext context;

    @Test
    void setsCorrectEnvironments() {
        var envs = context.getEnvironment().getActiveNames();
        assertTrue(envs.contains(Environment.API_MODE));
        assertTrue(envs.contains(Environment.TEST));
    }
}
