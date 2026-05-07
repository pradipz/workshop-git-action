package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final List<UserResponse> SAMPLE_USERS = List.of(
        new UserResponse(1L, "Alice Smith", "alice@example.com", LocalDateTime.of(2024, 1, 10, 9, 0)),
        new UserResponse(2L, "Bob Jones", "bob@example.com", LocalDateTime.of(2024, 2, 15, 14, 30)),
        new UserResponse(3L, "Carol White", "carol@example.com", LocalDateTime.of(2024, 3, 20, 11, 45))
    );

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(SAMPLE_USERS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return SAMPLE_USERS.stream()
            .filter(u -> u.id().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody Map<String, String> body) {
        UserResponse created = new UserResponse(
            SAMPLE_USERS.size() + 1L,
            body.getOrDefault("name", "Unknown"),
            body.getOrDefault("email", ""),
            LocalDateTime.now()
        );
        return ResponseEntity.status(201).body(created);
    }
}
