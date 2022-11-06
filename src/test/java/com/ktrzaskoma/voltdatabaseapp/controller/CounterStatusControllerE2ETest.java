package com.ktrzaskoma.voltdatabaseapp.controller;

import com.ktrzaskoma.voltdatabaseapp.adapter.CounterRepository;
import com.ktrzaskoma.voltdatabaseapp.adapter.CounterStatusRepository;
import com.ktrzaskoma.voltdatabaseapp.model.Counter;
import com.ktrzaskoma.voltdatabaseapp.model.CounterStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CounterStatusControllerE2ETest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    CounterStatusRepository counterStatusRepository;

    @Autowired
    private CounterRepository counterRepository;

    @Test
    @Disabled
    void http_returnAllCounterStatusesWithSpecifiedId() {

        var counterToTest = new Counter();
        counterToTest.setCounterStatuses(Set.of());

        int id = counterToTest.getId();

        var initial = counterRepository.findAll().size();


        counterStatusRepository.save(new CounterStatus("test value 1"));
        counterStatusRepository.save(new CounterStatus("test value 2"));

        Counter[] result = testRestTemplate.getForObject("http://localhost:" + port + "/counter/status/" + id, Counter[].class);
        assertThat(result).hasSize(initial + 2);
    }

}