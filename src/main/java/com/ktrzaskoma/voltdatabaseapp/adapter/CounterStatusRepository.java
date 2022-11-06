package com.ktrzaskoma.voltdatabaseapp.adapter;

import com.ktrzaskoma.voltdatabaseapp.model.CounterStatus;
import com.ktrzaskoma.voltdatabaseapp.model.CounterStatusPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounterStatusRepository extends JpaRepository<CounterStatus, CounterStatusPrimaryKey> {

    List<CounterStatus> findByCounterStatusPrimaryKeyId(int id);


}