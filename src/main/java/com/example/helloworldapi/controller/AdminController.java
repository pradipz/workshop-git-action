package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.AdminResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping("/info")
    public ResponseEntity<AdminResponse> info() {
        return ResponseEntity.ok(new AdminResponse("Admin info for hello-world-api", "admin", LocalDateTime.now()));
    }

    @GetMapping("/status")
    public ResponseEntity<AdminResponse> status() {
        return ResponseEntity.ok(new AdminResponse("System is running", "admin", LocalDateTime.now()));
    }
}
