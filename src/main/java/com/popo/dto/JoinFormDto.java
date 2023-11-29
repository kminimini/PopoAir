package com.popo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class JoinFormDto {

	private String name;
	private String email;
	private String password;
	private String address;
	
	@Builder
	public void JoinFormDto(String name, String email, String password, String address) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}


	
}