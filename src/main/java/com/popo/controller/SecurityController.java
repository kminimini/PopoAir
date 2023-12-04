package com.popo.controller;

<<<<<<< HEAD
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
	

	/*
	@PostMapping("/login")
    public String loginAction(Member member, Model model) {
        Member findMember = memberService.getMember(member.getEmail());

        System.out.println("Member password="+member.getPassword());
        System.out.println("Findmember password="+findMember.getPassword());
        
        if (findMember != null && passwordEncoder.matches(member.getPassword(), findMember.getPassword())) {
            // 정상 사용자
            model.addAttribute("member", findMember);
            System.out.println("로그인 성공: " + findMember.getName());
            return "redirect:/index";
        } else {
            // 로그인 인증 실패
        	return "redirect:login";
        }
    }
    */
	

	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:index";
	}
}
	

=======
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
>>>>>>> refs/heads/develop
