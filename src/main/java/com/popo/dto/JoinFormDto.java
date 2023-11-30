package com.popo.dto;


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
	
	@Builder
	public void JoinFormDto(String id,String name, String email, String password, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}


	
}