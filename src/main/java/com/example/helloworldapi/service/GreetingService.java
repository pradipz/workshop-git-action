package com.example.helloworldapi.service;

import com.example.helloworldapi.model.GreetingResponse;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private static final String DEFAULT_NAME = "World";

    public GreetingResponse hello(String name) {
        return GreetingResponse.hello(resolveName(name));
    }

    public GreetingResponse goodbye(String name) {
        return GreetingResponse.goodbye(resolveName(name));
    }

    private String resolveName(String name) {
        return (name != null && !name.isBlank()) ? name : DEFAULT_NAME;
    }
}
