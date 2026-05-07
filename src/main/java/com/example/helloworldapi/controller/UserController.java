package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.UserRequest;
import com.example.helloworldapi.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final List<UserResponse> SAMPLE_USERS = List.of(
        new UserResponse(1L, "Alice Smith", "alice@example.com", LocalDateTime.of(2024, 1, 15, 10, 0)),
        new UserResponse(2L, "Bob Jones", "bob@example.com", LocalDateTime.of(2024, 2, 20, 14, 30))
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
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        UserResponse created = new UserResponse(
            (long) (SAMPLE_USERS.size() + 1),
            request.name(),
            request.email(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
