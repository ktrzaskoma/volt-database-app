package com.ktrzaskoma.voltdatabaseapp.controller;

import com.ktrzaskoma.voltdatabaseapp.adapter.CounterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CounterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CounterRepository counterRepository;

    @Test
    void http_returnAllCounters() throws Exception {

        mockMvc.perform(get("/counter"))
                .andExpect(status().is2xxSuccessful());
    }

}
