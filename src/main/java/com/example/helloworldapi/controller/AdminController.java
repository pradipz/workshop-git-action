package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.AdminResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private static final String ADMIN_USER = "admin";

    @GetMapping("/info")
    public ResponseEntity<AdminResponse> info() {
        return ResponseEntity.ok(AdminResponse.info(ADMIN_USER));
    }

    @GetMapping("/status")
    public ResponseEntity<AdminResponse> status() {
        return ResponseEntity.ok(AdminResponse.status(ADMIN_USER));
    }
}
