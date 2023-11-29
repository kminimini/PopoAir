package com.popo.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.popo.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

//	Optional<Member> findById(String id);
}
