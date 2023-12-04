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
	
	@GetMapping("/index")
	public void mainView() {
		
	}
	
	@GetMapping("/agree")
	public String agree() {
		return "/system/agree";
	}
	
	@PostMapping("/agree")
	public String checkagree(Model model) {
		return "/system/agree";
	}
	
	@GetMapping("/contract")
	public String contract() {
		return "/system/contract";
	}
	
	@PostMapping("/contract")
	public String showcontract(Model model) {
		return "/system/contract";
	}
	
//	@GetMapping("/findIdView")
//	public String findIdView() throws Exception{
//		return"/system/findIDView";
//	}
//	
//	@PostMapping("/findIdView")
//	public String findId(Member member,Model model) throws Exception{
//		logger.info("memberEmail"+memberVO.getMemberEmail());
//				
//		if(memberService.findIdCheck(memberVO.getMemberEmail())==0) {
//		model.addAttribute("msg", "이메일을 확인해주세요");
//		return "/member/findIdView";
//		}else {
//		model.addAttribute("member", memberService.findId(memberVO.getMemberEmail()));
//		return
//				"/member/findId";
//		}
//	}
	
	

}
