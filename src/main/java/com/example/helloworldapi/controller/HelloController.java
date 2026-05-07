package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.HelloResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<HelloResponse> hello() {
        return ResponseEntity.ok(HelloResponse.of("World"));
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<HelloResponse> helloByName(@PathVariable String name) {
        return ResponseEntity.ok(HelloResponse.of(name));
    }

    @PostMapping("/hello")
    public ResponseEntity<HelloResponse> helloPost(@RequestBody(required = false) NameRequest request) {
        String name = (request != null && request.name() != null) ? request.name() : "World";
        return ResponseEntity.ok(HelloResponse.of(name));
    }

    public record NameRequest(String name) {}
}
