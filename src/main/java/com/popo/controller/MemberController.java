package com.popo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.popo.domain.Member;
import com.popo.repository.MemberRepository;
import com.popo.service.MemberService;

@Controller
public class MemberController {

	
	// 로거 초기화
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRepository memberRepository;

	
	@GetMapping("/index")
	public String mainView() {
		
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
	
	// 회원 정보
	@GetMapping("/admin/members")
	public String listMembers(Model model) {
	    List<Member> members = memberService.getAllMembers();
	    model.addAttribute("members", members);
	    return "/admin/members";
	}
}
