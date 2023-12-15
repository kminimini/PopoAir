package com.popo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.popo.domain.ParkInfo;

public interface ParkInfoRepository extends JpaRepository<ParkInfo, String> {

}
