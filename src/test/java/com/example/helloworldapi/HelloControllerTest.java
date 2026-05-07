package com.example.helloworldapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // --- Hello endpoints ---

    @Test
    void helloReturnsWorld() throws Exception {
        mockMvc.perform(get("/api/v1/hello"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Hello, World!"))
            .andExpect(jsonPath("$.name").value("World"));
    }

    @Test
    void helloByNameReturnsThatName() throws Exception {
        mockMvc.perform(get("/api/v1/hello/Pradip"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Hello, Pradip!"))
            .andExpect(jsonPath("$.name").value("Pradip"));
    }

    @Test
    void helloPostWithBodyReturnsName() throws Exception {
        mockMvc.perform(post("/api/v1/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Spring\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Hello, Spring!"));
    }

    @Test
    void helloPostWithoutBodyReturnsWorld() throws Exception {
        mockMvc.perform(post("/api/v1/hello"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Hello, World!"));
    }

    // --- Goodbye endpoints ---

    @Test
    void goodbyeReturnsWorld() throws Exception {
        mockMvc.perform(get("/api/v1/goodbye"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Goodbye, World!"))
            .andExpect(jsonPath("$.name").value("World"));
    }

    @Test
    void goodbyeByNameReturnsThatName() throws Exception {
        mockMvc.perform(get("/api/v1/goodbye/Pradip"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Goodbye, Pradip!"))
            .andExpect(jsonPath("$.name").value("Pradip"));
    }

    @Test
    void goodbyePostWithBodyReturnsName() throws Exception {
        mockMvc.perform(post("/api/v1/goodbye")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Spring\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Goodbye, Spring!"));
    }

    @Test
    void goodbyePostWithoutBodyReturnsWorld() throws Exception {
        mockMvc.perform(post("/api/v1/goodbye"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Goodbye, World!"));
    }
}
