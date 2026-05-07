package com.example.helloworldapi.model;

import java.time.LocalDateTime;

public record HealthResponse(String status, String version, LocalDateTime timestamp) {

    public static HealthResponse up(String version) {
        return new HealthResponse("UP", version, LocalDateTime.now());
    }
}
