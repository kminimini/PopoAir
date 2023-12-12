package com.popo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.popo.domain.Member;
import com.popo.service.MemberService;

@Controller
public class MyPageController {

    @Autowired
    private MemberService memberService;

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
