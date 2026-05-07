package com.example.helloworldapi.model;

import java.time.LocalDateTime;

public record GreetingResponse(String message, String name, LocalDateTime timestamp) {

    public static GreetingResponse hello(String name) {
        return new GreetingResponse("Hello, " + name + "!", name, LocalDateTime.now());
    }

    public static GreetingResponse goodbye(String name) {
        return new GreetingResponse("Goodbye, " + name + "!", name, LocalDateTime.now());
    }
}
