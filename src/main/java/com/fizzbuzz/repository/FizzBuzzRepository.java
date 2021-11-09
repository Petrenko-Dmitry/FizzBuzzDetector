package com.fizzbuzz.repository;

import com.fizzbuzz.entity.FizzBuzz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FizzBuzzRepository extends JpaRepository<FizzBuzz,Long> {
    List<FizzBuzz> findByCountBuzz(Integer count);
}
