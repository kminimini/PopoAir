package com.popo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.popo.domain.Member;
import com.popo.domain.Role;
import com.popo.dto.JoinFormDto;
import com.popo.service.MemberService;


@Controller
@RequestMapping("/system")
public class SecurityController {
	
	@Autowired
	private MemberService memberService;
	
	public SecurityController(MemberService memberService) {
        this.memberService = memberService;
    }
	
	/* TODO 로그인 화면 이동 */
	@GetMapping("/login")
	public void showLoginPage() {
		
	}
	
	
	@PostMapping("/login")
	public String loginAction(Member member, HttpSession session, Model model) {
	    Member findMember = memberService.getMember(member.getEmail());

	    if (findMember != null && passwordMatches(member.getPassword(), findMember.getPassword())) {
	        // Spring Security를 사용하여 로그인한 회원에 대한 추가 정보 가져오기
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        Member loggedInMemberWithDetails = (Member) authentication.getPrincipal();

	        // 추가 정보를 세션 또는 모델에 필요한 대로 저장
	        session.setAttribute("loggedInMember", loggedInMemberWithDetails);
	        System.out.println("로그인 성공: " + loggedInMemberWithDetails.getEmail());

	        return "redirect:/insertBoard"; // 로그인 성공 후 지정된 URL로 리디렉션
	    } else {
	        model.addAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
	        return "/system/login";
	    }
	}

	
	/* TODO 회원가입 화면 이동 */
	@GetMapping("/join")
	public String showJoinForm(Model model, JoinFormDto joinFormDto) {
		memberService.entitySave(joinFormDto);
		return "/system/join";
	}

	
	/* TODO 회원가입 */
	@PostMapping("/join")
	public String registerUser(@ModelAttribute("joinFormDto") JoinFormDto joinFormDto) {
	    // 여기에 추가 유효성 검사 및 로직을 추가할 수 있습니다.

	    // JoinFormDto를 Member로 변환
	    Member member = new Member();
	    member.setId(joinFormDto.getId());
	    member.setName(joinFormDto.getName());
	    member.setEmail(joinFormDto.getEmail());
	    member.setAddress(joinFormDto.getAddress());

	    // 사용자 역할 설정(역할 열거형에 'ROLE_USER' 역할이 있다고 가정)
	    member.setRole(Role.ROLE_MEMBER);

	    // 저장하기 전에 비밀번호 인코딩
	    member.setPassword(joinFormDto.getPassword());

	    // 활성화 상태 설정(로직에 따라 사용자 지정할 수 있음)
	    member.setEnabled("true");

	    // 사용자 저장
	    memberService.save(member);

	    // 등록 성공 후 로그인 페이지로 리디렉션
	    return "redirect:/index"; 
	}
	

	// 패스워드 일치 여부를 확인하는 메서드
	private boolean passwordMatches(String rawPassword, String encodedPassword) {
	    // 여기에 비밀번호 일치 여부를 확인하는 로직을 추가합니다.
	    // 예를 들어, Spring Security의 PasswordEncoder를 사용하는 것이 좋습니다.

	    // 아래는 간단한 문자열 비교 예시입니다. 실제로는 보안을 고려하여 PasswordEncoder를 사용해야 합니다.
	    return rawPassword.equals(encodedPassword);
	}
  
	

	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:index";
	}
	
}
