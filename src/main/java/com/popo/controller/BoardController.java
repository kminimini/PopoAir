package com.popo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.popo.domain.Board;
import com.popo.domain.Search;
import com.popo.service.BoardService;



@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/*
	@GetMapping("/getBoardList")
	public String getBoardList(Board board, Model model) {
		List<Board> boardList = boardService.getBoardList(board);
		
		/*
		List<Board> boardList = new ArrayList<Board>();
		
		for(int i=1; i<=10; i++) {
			Board board = Board.builder()
					.seq(Long.valueOf(i))
					.title("게시글 제목 " + i)
					.writer("홍길동")
					.content("게시글 내용 " + i)
					.createDate(new Date())
					.cnt(0L)
					.build();
			
			boardList.add(board);
		}
		
		
		model.addAttribute("boardList", boardList);
		
		return "getBoardList";
	}
	*/
		
	/* 리스트 보기 */
	@RequestMapping("/getBoardList")
    public void getBoardList(Model model, Search search, @RequestParam(defaultValue = "0") int page) {
        if (search.getSearchCondition() == null) {
            search.setSearchCondition("TITLE");
        }

        if (search.getSearchKeyword() == null) {
            search.setSearchKeyword("");
        }

        Pageable pageable = PageRequest.of(page, 10, Sort.by("seq").descending());
        Page<Board> boardList = boardService.getBoardList(pageable, search);

        model.addAttribute("boardList", boardList);
    }

	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		
		return "redirect:getBoardList";
	}
	
	@GetMapping("getBoard")
	public String getBoard(Board board, Model model) {
		
		model.addAttribute("board", boardService.getBoard(board));
		
		return "getBoard";
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		
		return "redirect:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		
		return "redirect:getBoardList";
	}
}



















