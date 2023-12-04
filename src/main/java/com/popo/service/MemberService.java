package com.popo.service;

import java.util.List;

import com.popo.domain.Member;
import com.popo.dto.JoinFormDto;

public interface MemberService {

	String entitySave (JoinFormDto joinFormDto);

	void save(Member member);

	Member getMember(String email);

//	public int findIdCheck(String eamil)throws Exception;
	
}

