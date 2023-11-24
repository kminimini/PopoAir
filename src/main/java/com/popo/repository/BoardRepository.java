package com.popo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.popo.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
