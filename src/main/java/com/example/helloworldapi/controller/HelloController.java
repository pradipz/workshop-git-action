package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.GreetingResponse;
import com.example.helloworldapi.model.NameRequest;
import com.example.helloworldapi.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public ResponseEntity<GreetingResponse> hello() {
        return ResponseEntity.ok(greetingService.hello(null));
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<GreetingResponse> helloByName(@PathVariable String name) {
        return ResponseEntity.ok(greetingService.hello(name));
    }

    @PostMapping("/hello")
    public ResponseEntity<GreetingResponse> helloPost(@RequestBody(required = false) NameRequest request) {
        return ResponseEntity.ok(greetingService.hello(request != null ? request.name() : null));
    }

    @GetMapping("/goodbye")
    public ResponseEntity<GreetingResponse> goodbye() {
        return ResponseEntity.ok(greetingService.goodbye(null));
    }

    @GetMapping("/goodbye/{name}")
    public ResponseEntity<GreetingResponse> goodbyeByName(@PathVariable String name) {
        return ResponseEntity.ok(greetingService.goodbye(name));
    }

    @PostMapping("/goodbye")
    public ResponseEntity<GreetingResponse> goodbyePost(@RequestBody(required = false) NameRequest request) {
        return ResponseEntity.ok(greetingService.goodbye(request != null ? request.name() : null));
    }
}
