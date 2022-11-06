package com.ktrzaskoma.voltdatabaseapp.adapter;

import com.ktrzaskoma.voltdatabaseapp.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Integer> {

    List<Counter> findAll();
    Optional<Counter> findById(Integer id);

}
