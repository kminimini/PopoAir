package com.popo.service;

import com.popo.domain.Member;
import com.popo.dto.JoinFormDto;

public interface MemberService {

	String Member (JoinFormDto joinFormDto);

	void save(Member member);

	Member Member(String name);
}

