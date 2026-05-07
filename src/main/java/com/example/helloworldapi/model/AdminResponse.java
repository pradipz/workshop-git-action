package com.example.helloworldapi.model;

import java.time.LocalDateTime;

public record AdminResponse(String message, String adminUser, LocalDateTime timestamp) {
}
