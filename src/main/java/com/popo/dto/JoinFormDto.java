package com.popo.dto;


import org.springframework.beans.factory.annotation.Autowired;

import com.popo.domain.Role;
import com.popo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class JoinFormDto {

	
	private String id;
	private String name;
	private String email;
	private String password;
	private String address;
	private Role role;
	private String enabled;
	
	@Builder
	public void JoinFormDto(String id,String name, String email, String password, String address, Role role, String enabled) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.role = role;
		this.enabled = enabled;
	}


	
}