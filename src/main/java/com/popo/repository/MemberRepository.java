package com.popo.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.popo.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {	// String 이 원래임

	//Optional<Member> findById(String username);
	
	Optional<Member> findByEmail(String email);
	
//	public int findIdCheck(String email)throws Exception;
	
    // 추가된 메서드
    Optional<Member> findById(String memberId);
 

	
}
