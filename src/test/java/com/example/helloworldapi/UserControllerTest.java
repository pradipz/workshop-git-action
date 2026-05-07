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
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUsersReturnsListOfUsers() throws Exception {
        mockMvc.perform(get("/api/v1/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$.length()").value(3))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].name").value("Alice Smith"))
            .andExpect(jsonPath("$[0].email").value("alice@example.com"));
    }

    @Test
    void getUserByIdReturnsUser() throws Exception {
        mockMvc.perform(get("/api/v1/users/2"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(2))
            .andExpect(jsonPath("$.name").value("Bob Jones"))
            .andExpect(jsonPath("$.email").value("bob@example.com"));
    }

    @Test
    void getUserByIdReturns404ForUnknownId() throws Exception {
        mockMvc.perform(get("/api/v1/users/999"))
            .andExpect(status().isNotFound());
    }

    @Test
    void createUserReturnsCreatedUser() throws Exception {
        mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Dave Brown\", \"email\": \"dave@example.com\"}"))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("Dave Brown"))
            .andExpect(jsonPath("$.email").value("dave@example.com"))
            .andExpect(jsonPath("$.id").isNumber())
            .andExpect(jsonPath("$.createdAt").isNotEmpty());
    }
}
