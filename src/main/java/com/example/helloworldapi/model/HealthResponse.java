package com.example.helloworldapi.model;

import java.time.LocalDateTime;

public record HealthResponse(String status, String version, LocalDateTime timestamp) {
}
