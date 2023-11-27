package com.popo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 반응 테스트용 클래스
 */

@Controller
public class SecurityController {

	@GetMapping("/")
	public String index() {
		System.out.println("Index 요청입니다.");
		
		return "index";
	}
	
	/* 로그인 화면 표시 요청 처리 */
	@GetMapping("/login")
	public void login() {
		
	}
	
	/* 로그인 성공시 처리하는 메소드 */
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		
	}
	
	/* 접근 권한 없음 페이지 처리 */
	@GetMapping("/accessDenied")
	public void accessDenied() {
		
	}
	
	@GetMapping("/member")
	public void forMember() {
		System.out.println("Member 요청입니다.");		
	}
	
	@GetMapping("/manager")
	public void forManager() {
		System.out.println("Manager 요청입니다.");		
	}
	
	@GetMapping("/admin")
	public void forAdmin() {
		System.out.println("Admin 요청입니다.");		
	}
}
