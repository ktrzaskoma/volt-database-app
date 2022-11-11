package com.ktrzaskoma.voltdatabaseapp.service;

import com.ktrzaskoma.voltdatabaseapp.model.CounterStatus;
import com.ktrzaskoma.voltdatabaseapp.repository.CounterStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CounterStatusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CounterStatusService.class);
    private final CounterStatusRepository counterStatusRepository;

    public CounterStatusService(final CounterStatusRepository counterStatusRepository) {
        this.counterStatusRepository = counterStatusRepository;
    }

    public void getTaxPrice(int id) {
        LOGGER.info("Value save & added");
        counterStatusRepository.findByCounterStatusPrimaryKeyId(id).forEach(this::setAdditionalValue);
    }

    private void setAdditionalValue(CounterStatus counterStatus){
        LOGGER.info("New value saved");
        counterStatus.setMeasurement(counterStatus.getMeasurement() + 100);
        counterStatusRepository.save(counterStatus);
    }
}
