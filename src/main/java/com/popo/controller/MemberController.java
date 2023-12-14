package com.popo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.popo.domain.Member;
import com.popo.repository.MemberRepository;
import com.popo.service.MemberService;

@Controller
public class MemberController {
    
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRepository memberRepository;

	
	@GetMapping("/index")
	public String mainView(Model model) {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    // 로그 추가
	    System.out.println("Authentication: " + authentication);

	    if (authentication != null && authentication.isAuthenticated()) {
	        // 사용자가 인증되었을 때, 사용자 이름 또는 관련된 사용자 정보를 제공
	        model.addAttribute("authenticated", true);
	        model.addAttribute("username", authentication.getName());
	    }

	    // 다른 로직을 추가할 수 있음

	    return "index";
	}
	
	@GetMapping("/agree")
	public String agree() {
		return "/system/agree";
	}
	
	@PostMapping("/agree")
	public String checkagree(Model model) {
		return "/system/join";
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
