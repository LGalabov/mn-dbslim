package com.example.config;

public interface Environment {

    /**
     * Environment with enabled controllers.
     */
    String API_MODE = "apimode";

    /**
     * Environment with enabled background jobs.
     */
    String BG_MODE = "bgmode";

    /**
     * The test environment.
     */
    String TEST = "test";
}
