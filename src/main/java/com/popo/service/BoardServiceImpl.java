package com.popo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.popo.domain.Board;
import com.popo.domain.QBoard;
import com.popo.domain.Search;
import com.popo.repository.BoardRepository;
import com.querydsl.core.BooleanBuilder;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public List<Board> getBoardList(Board board) {
		
		return (List<Board>) boardRepo.findAll();
	}
	
	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
	@Transactional
	@Override
	public Board getBoard(Board board) {
	    Long seq = board.getBseq();
	    Optional<Board> optionalBoard = boardRepo.findById(seq);

	    if (optionalBoard.isPresent()) {
	        Board existingBoard = optionalBoard.get();
	        Long newCnt = existingBoard.getCnt() + 1L;
	        existingBoard.setCnt(newCnt);
	        board = existingBoard;
	        boardRepo.save(board);
	        
	        return board;
	    } else {
	        // 해당하는 seq에 해당하는 Board가 없을 경우 처리 (예: 예외를 던지거나 새로운 Board를 생성하는 등)
	        return null;
	    }
	}
	
	@Override
	public void updateBoard(Board board) {
		Board newBoard = boardRepo.findById(board.getBseq()).get();
		
		newBoard.setBtitle(board.getBtitle());
		newBoard.setBcontent(board.getBcontent());
		boardRepo.save(newBoard);
	}
	
	@Override
	public void deleteBoard(Board board) {
		
		boardRepo.deleteById(board.getBseq());
	}

	@Override
	public Page<Board> getBoardList(Pageable pageable, Search search) {
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if (search.getSearchCondition().equals("TITLE")) {
			builder.and(qboard.btitle.like("%" + search.getSearchKeyword() + "%"));
		} else if (search.getSearchCondition().equals("CONTENT")) {
			builder.and(qboard.bcontent.like("%" + search.getSearchKeyword() + "%"));
		}
		
		return boardRepo.findAll(builder, pageable);
	}
	
	
	
}














