package com.pilot.api.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilot.api.member.domain.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	public Member findByMemberIdAndPasswd(String memberId, String passwd);
	
	public Optional<Member> findByMemberId(String memberId);
	
	
}
