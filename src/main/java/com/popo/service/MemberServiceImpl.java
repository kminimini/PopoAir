package com.popo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.popo.domain.Member;
import com.popo.dto.JoinFormDto;
import com.popo.repository.MemberRepository;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public String Member(JoinFormDto joinFormDto) {
		Member member = Member.builder()
				.email(joinFormDto.getEmail())
				.name(joinFormDto.getName())
				.password(joinFormDto.getPassword())
				.build();
		
		return memberRepository.save(member).getId();
	}

	

	
}
	
	

