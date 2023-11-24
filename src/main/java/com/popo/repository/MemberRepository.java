package com.popo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.popo.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
