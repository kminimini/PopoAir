package com.popo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.popo.domain.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {

}
