package com.ktrzaskoma.voltdatabaseapp.controller;

import com.ktrzaskoma.voltdatabaseapp.adapter.CounterRepository;
import com.ktrzaskoma.voltdatabaseapp.model.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
class CounterController {
    private static final Logger logger = LoggerFactory.getLogger(CounterController.class);
    private final CounterRepository counterRepository;

    CounterController(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @GetMapping("/counter")
    ResponseEntity<List<Counter>> readAllCounters() {
        logger.warn("Exposing all the volt counters!");
        return ResponseEntity.ok(counterRepository.findAll());
    }

    @PostMapping("/counter")
    ResponseEntity<Counter> creatCounter(@RequestBody Counter toCreat){
        Counter counter = counterRepository.save(toCreat);
        return  ResponseEntity.created(URI.create("/" + counter.getId())).body(counter);
    }

    @GetMapping("/counter/{id}")
    ResponseEntity<?> readCounter(@PathVariable int id) {
        return counterRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
