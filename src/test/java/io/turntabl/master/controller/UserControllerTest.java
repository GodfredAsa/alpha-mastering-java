package io.turntabl.master.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerTest {

    @Autowired private MockMvc mockMvc;

    @Test
    void shouldGetAllUsers() throws Exception {
        this.mockMvc
                .perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));
    }

    @Test
    void shouldCreateUser() throws Exception {
        this.mockMvc
                .perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization","")
                        .content("{\"firstname\": \"John\",\"lastname\": \"Doe\",\"phoneNumber\": \"0500001593\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstname").value("John"));
    }
}