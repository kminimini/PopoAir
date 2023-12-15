package com.popo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.popo.domain.Member;
import com.popo.dto.JoinFormDto;

@Service
public interface MemberService {

	String entitySave (JoinFormDto joinFormDto);

	void save(Member member);

	Member getMember(String email);
	

//	public int findIdCheck(String eamil)throws Exception;

	// 회원 목록 불러오기
	List<Member> getAllMembers();
	
	// mypage
	Member findById(Long id);
	
	// 회원 탈퇴
	void deleteMemberById(Long memberId);
	
	// 비밀번호 변경
	boolean isCurrentPasswordValid(String currentPassword);
    boolean changePassword(String currentPassword, String newPassword);
    Member getCurrentMember();
		
}
