package com.example;

import com.example.config.Environment;
import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.context.ApplicationContextConfigurer;
import io.micronaut.context.annotation.ContextConfigurer;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.runtime.Micronaut;

public class Application {

    @ContextConfigurer
    @SuppressWarnings("unused")
    public static class DefaultEnvironmentConfigurer implements ApplicationContextConfigurer {
        @Override
        public void configure(@NonNull ApplicationContextBuilder builder) {
            builder.defaultEnvironments(Environment.API_MODE);
        }
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
