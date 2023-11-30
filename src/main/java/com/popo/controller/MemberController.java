package com.popo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.popo.dto.JoinFormDto;
import com.popo.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

//	@RequestMapping("/system")
//	public void index() {
//
//	}
	
	@GetMapping("/agree")
	public String agree() {
		return "/system/agree";
	}
	
	@PostMapping("/agree")
	public String checkagree(Model model) {
		return "/system/agree";
	}
	
//	@GetMapping("/join")
//	public String createjoin(JoinFormDto joinFormDto) {
//		memberService.Member(joinFormDto);
//		return "/system/join";
//	}
	
	

}
