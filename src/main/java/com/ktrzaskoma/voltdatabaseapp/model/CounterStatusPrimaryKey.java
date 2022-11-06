package com.ktrzaskoma.voltdatabaseapp.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class CounterStatusPrimaryKey implements Serializable {

    private int id;
    private LocalDateTime dateOfTheMeasurement = LocalDateTime.now();

    LocalDateTime getDateOfTheMeasurement() {
        return dateOfTheMeasurement;
    }

    void setDateOfTheMeasurement(final LocalDateTime dateOfTheMeasurement) {
        this.dateOfTheMeasurement = dateOfTheMeasurement;
    }

    int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }
}
