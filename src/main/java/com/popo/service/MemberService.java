package com.popo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.popo.domain.Member;
import com.popo.dto.JoinFormDto;

public interface MemberService {

	String entitySave (JoinFormDto joinFormDto);

	void save(Member member);

	Member getMember(String email);

	public List<Member> findId(String email)throws Exception;
	
	 // 이름과 전화번호를 통한 이메일 찾기
    String findEmailByNameAndPhone(String name, String phoneNumber) throws Exception;

    //아이디 중복체크
    int findidCheck(String id);
    
//    int findemailCheck(String email);
    
 // 아이디와 이메일로 멤버 찾기
    Member getMemberByIdAndEmail(String id, String email);

	Optional<Member> getMemberByEmail(String username);



}

