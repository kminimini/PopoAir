package com.popo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.popo.service.BoardService;
import com.popo.service.BoardServiceImpl;

@Configuration
public class BoardConfig {

	@Bean
	public BoardService boardService() {
		return new BoardServiceImpl();
	}
}
