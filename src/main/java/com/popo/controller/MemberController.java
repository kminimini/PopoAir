package com.popo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.popo.domain.Member;
import com.popo.dto.MailDto;
import com.popo.service.MailService;
import com.popo.service.MemberService;
import com.popo.service.SendEmailService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

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

	@GetMapping("/findIdView")
	public String findIdView() throws Exception {
		return "/system/findIdView";
	}

	@PostMapping("/findIdView")
	public ResponseEntity<Map<String, Object>> findIdView(@RequestBody Map<String, String> requestData) {
		String name = requestData.get("name");
		String phone = requestData.get("phone");

		try {
			String foundEmail = memberService.findEmailByNameAndPhone(name, phone);

			if (foundEmail != null) {
				Map<String, Object> responseData = new HashMap<>();
				responseData.put("success", true);
				responseData.put("email", foundEmail);
				return ResponseEntity.ok(responseData);
			} else {
				Map<String, Object> responseData = new HashMap<>();
				responseData.put("success", false);
				return ResponseEntity.ok(responseData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}


	

}
