package com.popo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String loginAction(Member member, Model model) {
        Member findMember = memberService.getMember(member.getEmail());

        System.out.println("Member password=" + member.getPassword());
        System.out.println("Findmember password=" + findMember.getPassword());

        if (findMember != null && passwordMatches(member.getPassword(), findMember.getPassword())) {
            // 정상 사용자
            model.addAttribute("member", findMember);
            System.out.println("로그인 성공: " + findMember.getEmail());
            return "redirect:/index";
        } else {
            // 로그인 인증 실패
            model.addAttribute("error", "아이디나 비밀번호가 틀렸습니다.");
            return "redirect:/login";
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
    public String registerUser(Member member) {
        // 여기에 추가 유효성 검사 및 로직을 추가할 수 있습니다.
		member.setId(member.getId());
		member.setName(member.getName());
		member.setEmail(member.getEmail());
		member.setAddress(member.getAddress());
		
        // 사용자 역할 설정(역할 열거형에 'ROLE_USER' 역할이 있다고 가정)
        member.setRole(Role.ROLE_MEMBER);

        // 저장하기 전에 비밀번호 인코딩
        member.setPassword(member.getPassword());

        // 활성화 상태 설정(로직에 따라 사용자 지정할 수 있음)
        member.setEnabled("true");

        // 사용자 저장
        memberService.save(member);

        // 등록 성공 후 로그인 페이지로 리디렉션
        return "/system/login";
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
	