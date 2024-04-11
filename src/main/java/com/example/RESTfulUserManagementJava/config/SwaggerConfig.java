package com.example.RESTfulUserManagementJava.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("spring")
                .packagesToScan("src.main.java.com.example.RESTfulUserManagementJava.controller")
                .build();
    }
}
