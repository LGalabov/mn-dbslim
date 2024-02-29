package com.example.config;

import io.micronaut.context.annotation.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("application")
public interface ApplicationConfig {

    List<String> getLoremSentences();
}
