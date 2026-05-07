package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final List<UserResponse> SAMPLE_USERS = List.of(
        new UserResponse(1L, "Alice", "alice@example.com", LocalDateTime.of(2024, 1, 10, 9, 0)),
        new UserResponse(2L, "Bob", "bob@example.com", LocalDateTime.of(2024, 2, 15, 12, 30))
    );

    @GetMapping
    public List<UserResponse> getUsers() {
        return SAMPLE_USERS;
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return SAMPLE_USERS.stream()
            .filter(u -> u.id().equals(id))
            .findFirst()
            .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserResponse request) {
        long newId = SAMPLE_USERS.stream().mapToLong(UserResponse::id).max().orElse(0L) + 1;
        return new UserResponse(newId, request.name(), request.email(), LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class UserNotFoundException extends RuntimeException {
        UserNotFoundException(Long id) {
            super("User not found: " + id);
        }
    }
}
