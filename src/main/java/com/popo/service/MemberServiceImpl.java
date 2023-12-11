package com.popo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.popo.controller.MemberController;
import com.popo.domain.Member;
import com.popo.dto.JoinFormDto;
import com.popo.repository.MemberRepository;


@Service
public class MemberServiceImpl implements MemberService{
	
	// 로거 초기화
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberRepository memberRepository;

	/*  RODO - 회원 등록 또는 업데이트
     * 이 메서드는 JoinFormDto에 제공된 정보를 기반으로 새 회원을 등록하거나 기존 회원을 업데이트합니다.
     * 이 메서드는 JoinFormDto의 데이터를 사용하여 Member 객체를 생성하고 MemberRepository를 사용하여 저장합니다.
     */
	@Override
	public String entitySave(JoinFormDto joinFormDto) {
		Member member = Member.builder()
				.id(joinFormDto.getId())
				.email(joinFormDto.getEmail())
				.name(joinFormDto.getName())
				.password(joinFormDto.getPassword())
				.build();
		
		return memberRepository.save(member).getMid().toString();
	}
	
	/* TODO - 회원 저장
     * 이 메서드는 MemberRepository를 사용하여 Member 객체를 데이터베이스에 저장합니다.
     * 이 메서드에는 @Transactional 주석이 추가되어 작업이 원자적임을 보장합니다.
     */
	@Override
	@Transactional
	public void save(Member member) {
		memberRepository.save(member);
		
	}

	/* TODO - 이름으로 멤버 가져오기
     * 이 메서드는 제공된 이름을 기준으로 데이터베이스에서 멤버 객체를 검색합니다.
     * 아직 구현되지 않았습니다
     */

	@Override
	public Member getMember(String email) {
		
		Optional<Member> result = memberRepository.findByEmail(email);
		
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}


//	@Override
//	public int findIdCheck(String eamil) throws Exception {
//		return memberRepository.findIdCheck(eamil);
//	}
	
	// 회원 목록 불러오기
	public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

}
	
	

