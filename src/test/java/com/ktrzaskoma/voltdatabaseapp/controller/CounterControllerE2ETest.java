package com.ktrzaskoma.voltdatabaseapp.controller;

import com.ktrzaskoma.voltdatabaseapp.adapter.CounterRepository;
import com.ktrzaskoma.voltdatabaseapp.model.Counter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CounterControllerE2ETest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CounterRepository counterRepository;

    @Test
    void http_returnAllCounterStatuses() {
        var initial = counterRepository.findAll().size();
        counterRepository.save(new Counter());
        counterRepository.save(new Counter());

        Counter[] result = testRestTemplate.getForObject("http://localhost:" + port + "/counter", Counter[].class);

        assertThat(result).hasSize(initial + 2);
    }
}