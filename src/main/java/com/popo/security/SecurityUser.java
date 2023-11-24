package com.popo.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.popo.domain.Member;


/*
 * JPA에서 조회한 Member 정보를 스프링 시큐리티에서
 * 사용할 UserDrtails 타입으로 변환하는 클래스
 */

public class SecurityUser extends User {
//	private static final long serialVersionUID = 1L;
	
	private Member member;
	
	// 생성자	
	public SecurityUser(Member member) {
		// 조상의 생성자를 호출하여 스프링 시큐리티에 id, password, role, id 사용유무 전달
		// 암호화 하지 않은 처리
//		super (member.getId(), "{noop}" + member.getPassword(),
//			AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		// 암호화 처리
		super(member.getId(), member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}

}
