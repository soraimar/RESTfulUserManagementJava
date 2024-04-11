package com.example.RESTfulUserManagementJava.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/ping")
    @Operation(summary = "Health check endpoint")
    public String ping() {
        return "pong";
    }
}
