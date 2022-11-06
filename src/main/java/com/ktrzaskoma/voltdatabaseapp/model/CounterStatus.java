package com.ktrzaskoma.voltdatabaseapp.model;


import javax.persistence.*;

@Entity
public class CounterStatus {

    @EmbeddedId
    CounterStatusPrimaryKey counterStatusPrimaryKey;

    private String measurement;

    @MapsId("id")
    @JoinColumn(name="counter_fk", referencedColumnName = "Id")
    @ManyToOne
    private Counter counter;


    public CounterStatus(final String measurement) {
        this.counterStatusPrimaryKey = new CounterStatusPrimaryKey();
        this.measurement = measurement;
        this.counter = new Counter();
    }

    public CounterStatus() {
        this.counterStatusPrimaryKey = new CounterStatusPrimaryKey();
    }

    public CounterStatusPrimaryKey getCounterId() {
        return counterStatusPrimaryKey;
    }

    public void setCounterId(final CounterStatusPrimaryKey counterStatusPrimaryKey) {
        this.counterStatusPrimaryKey = counterStatusPrimaryKey;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(final String measurement) {
        this.measurement = measurement;
    }

    public CounterStatusPrimaryKey getCounterStatusPrimaryKey() {
        return counterStatusPrimaryKey;
    }

    public void setCounterStatusPrimaryKey(final CounterStatusPrimaryKey counterStatusPrimaryKey) {
        this.counterStatusPrimaryKey = counterStatusPrimaryKey;
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(final Counter counter) {
        this.counter = counter;
    }
}
