package com.popo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.popo.domain.Member;
import com.popo.security.SecurityUser;
import com.popo.service.MemberService;

@Controller
public class MyPageController {

    @Autowired
    private MemberService memberService;

    private static final Logger log = LoggerFactory.getLogger(MyPageController.class);
    
    // 마이페이지
    @GetMapping("/myPage")
    public String myPage(@AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : member") Object principal, Model model) {
        // 사용자가 로그인하지 않은 경우
        if (principal == null) {
            // 필요에 따라 로그인 페이지로 리다이렉트 또는 에러 메시지 표시 등의 처리를 수행할 수 있습니다.
            return "redirect:/system/login";
        }

        // MemberService가 주입되었으므로 findById 메소드 호출 가능
        Member currentMember = memberService.findById(((Member) principal).getMid());
        model.addAttribute("currentMember", currentMember);
        return "myPage";
    }
    
    // 비번 변경
    @PostMapping("/myPage/changePassword")
    public String changePassword(
            @AuthenticationPrincipal SecurityUser securityUser,
            @RequestParam String currentPassword,
            @RequestParam String newPassword,
            @RequestParam String confirmPassword,
            Model model) {
        
        try {
            // 비밀번호 변경 로직 추가
            memberService.changePassword(currentPassword, newPassword);
            
            // 비밀번호가 성공적으로 변경된 경우
            return "redirect:/system/login"; // 혹은 다른 적절한 페이지로 리다이렉트
        } catch (Exception e) {
            // 비밀번호 변경에 실패한 경우
            model.addAttribute("error", "Failed to change password");
            return "redirect:/myPage";  // 혹은 다른 적절한 페이지로 리다이렉트
        }
    }
    
 // 비밀번호 유효성 검사 핸들러
    @PostMapping("/myPage/validatePassword")
    @ResponseBody
    public String validatePassword(
            @AuthenticationPrincipal SecurityUser securityUser,
            @RequestParam String currentPassword,
            @RequestParam String newPassword) {
    	
    	System.out.println("currentPassword=" + currentPassword);
    	System.out.println("newPassword=" +newPassword);
        // 현재 사용자의 실제 비밀번호 
    	Member currentUser = securityUser.getMember();

    	Member member = memberService.getMember(currentUser.getEmail());
    	String userCurrentPassword = member.getPassword();
        
    	System.out.println("현재 비밀번호=" + userCurrentPassword);

        // 입력한 현재 비밀번호가 실제 비밀번호와 일치하는지 여부 확인
        if (currentPassword.equals(userCurrentPassword)) {
        	boolean result = memberService.changePassword(currentPassword, newPassword);
        	
        	if (result) {
        		System.out.println("success");
        		return "success";
        	} else {
        		System.out.println("failure");
        		return "failure";
        	}
        } else {
        	// 현재 비밀번호가 일치하지 않으면 "failure" 반환
        	System.out.println("failure2");
            return "failure";
        }
    }


    // 회원탈퇴
    @PostMapping("/myPage/deleteAccount")
    public String deleteAccount(@AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : member") Member currentMember, RedirectAttributes attributes) {
        try {
            if (currentMember != null) {
                // 삭제 로직 실행
                memberService.deleteMemberById(currentMember.getMid());
                attributes.addFlashAttribute("message", "Account deleted successfully");
                return "redirect:/";  // 리다이렉트 수정
            } else {
                // 로그인하지 않은 사용자에 대한 처리
                return "redirect:/system/login";
            }
        } catch (Exception e) {
            // 예외 처리 코드
            attributes.addFlashAttribute("error", "Error deleting account");
            return "redirect:/myPage";  // 리다이렉트 수정
        }
    }

}
