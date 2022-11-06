package com.ktrzaskoma.voltdatabaseapp.controller;

import com.ktrzaskoma.voltdatabaseapp.adapter.CounterStatusRepository;
import com.ktrzaskoma.voltdatabaseapp.model.CounterStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CounterStatusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CounterStatusRepository counterStatusRepository;

    @Test
    void http_returnAllCounterStatuses() throws Exception {

        int id = counterStatusRepository.save(new CounterStatus("test value 0")).getCounter().getId();

        mockMvc.perform(get("/counter/status/" + id))
                .andExpect(status().is2xxSuccessful());
    }

}