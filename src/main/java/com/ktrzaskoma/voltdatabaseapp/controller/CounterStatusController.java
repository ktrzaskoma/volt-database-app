package com.ktrzaskoma.voltdatabaseapp.controller;

import com.ktrzaskoma.voltdatabaseapp.adapter.CounterRepository;
import com.ktrzaskoma.voltdatabaseapp.adapter.CounterStatusRepository;
import com.ktrzaskoma.voltdatabaseapp.model.Counter;
import com.ktrzaskoma.voltdatabaseapp.model.CounterStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
class CounterStatusController {
    private static final Logger logger = LoggerFactory.getLogger(CounterController.class);
    private final CounterStatusRepository counterStatusRepository;
    private final CounterRepository counterRepository;

    CounterStatusController(final CounterStatusRepository counterStatusRepository, final CounterRepository counterRepository) {
        this.counterStatusRepository = counterStatusRepository;
        this.counterRepository = counterRepository;
    }

    @GetMapping("/counter/status/{id}")
    ResponseEntity<?> readCounterStatus(@PathVariable int id) {
        logger.warn("Showing statuses by id of Counter Controller");
        return ResponseEntity.ok(counterStatusRepository.findByCounterStatusPrimaryKeyId(id));

    }

    @PostMapping("/counter/status/{id}")
    ResponseEntity<?> createSingleCounterStatus(@PathVariable int id,
                                                @RequestBody CounterStatus toCreate) {
        Optional<Counter> counter = counterRepository.findById(id);
        toCreate.setCounter(counter.get());

        CounterStatus counterStatus = counterStatusRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + counterStatus)).body(counterStatus);
    }


}
