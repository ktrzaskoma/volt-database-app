package com.ktrzaskoma.voltdatabaseapp.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Counter{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "counter", orphanRemoval = true)
    private Set<CounterStatus> counterStatuses;

    public Counter() {
    }

    String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    Set<CounterStatus> getCounterStatuses() {
        return counterStatuses;
    }

    public void setCounterStatuses(final Set<CounterStatus> counterStatuses) {
        this.counterStatuses = counterStatuses;
    }

    public int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    Set<CounterStatus> getVoltCounterStatuses() {
        return counterStatuses;
    }

    void setVoltCounterStatuses(final Set<CounterStatus> counterStatuses) {
        this.counterStatuses = counterStatuses;
    }
}