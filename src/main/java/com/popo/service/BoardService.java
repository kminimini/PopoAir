package com.popo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.popo.config.*;
import com.popo.domain.Board;
import com.popo.domain.Search;

public interface BoardService {

	List<Board> getBoardList(Board board);

	void insertBoard(Board board);

	Board getBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

	Page<Board> getBoardList(Pageable pageable, Search search);
	
	Board getBoardById(Long bseq);
	
	Board getBoard(Long bseq);
	
	
}