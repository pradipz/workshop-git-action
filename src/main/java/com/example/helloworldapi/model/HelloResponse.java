package com.example.helloworldapi.model;

import java.time.LocalDateTime;

public record HelloResponse(String message, String name, LocalDateTime timestamp) {

    public static HelloResponse of(String name) {
        return new HelloResponse(
            "Hello, " + name + "!",
            name,
            LocalDateTime.now()
        );
    }
}
