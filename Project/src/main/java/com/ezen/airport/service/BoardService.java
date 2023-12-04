package com.ezen.airport.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.airport.entity.Board;
import com.ezen.airport.entity.Search;

public interface BoardService {

	List<Board> getBoardList(Board board);

	void insertBoard(Board board);

	Board getBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

	Page<Board> getBoardList(Pageable pageable, Search search);
}