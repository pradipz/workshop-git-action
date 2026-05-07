package com.example.helloworldapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void infoReturnsAdminInfo() throws Exception {
        mockMvc.perform(get("/api/v1/admin/info"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Admin info for hello-world-api"))
            .andExpect(jsonPath("$.adminUser").value("admin"))
            .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void statusReturnsSystemStatus() throws Exception {
        mockMvc.perform(get("/api/v1/admin/status"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("System is running"))
            .andExpect(jsonPath("$.adminUser").value("admin"))
            .andExpect(jsonPath("$.timestamp").exists());
    }
}
