package com.keyin.travelapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void home_shouldReturnWelcomeMessage() throws Exception {
        // Corrected expected message with "the" included
        String expectedMessage = "Welcome to the final sprint Travel-API Spring Boot Application. Happy Coding hay hay hay!";
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedMessage));
    }
}


