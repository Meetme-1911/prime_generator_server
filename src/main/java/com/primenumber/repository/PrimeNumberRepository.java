package com.primenumber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.primenumber.entity.PrimeNumber;
@Repository
public interface PrimeNumberRepository extends JpaRepository<PrimeNumber, Long> {

}
