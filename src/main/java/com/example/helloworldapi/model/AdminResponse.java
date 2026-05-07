package com.example.helloworldapi.model;

import java.time.LocalDateTime;

public record AdminResponse(String message, String adminUser, LocalDateTime timestamp) {

    public static AdminResponse info(String adminUser) {
        return new AdminResponse("Admin info retrieved successfully", adminUser, LocalDateTime.now());
    }

    public static AdminResponse status(String adminUser) {
        return new AdminResponse("System status: UP", adminUser, LocalDateTime.now());
    }
}
