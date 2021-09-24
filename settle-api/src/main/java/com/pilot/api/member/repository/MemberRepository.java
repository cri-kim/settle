package com.pilot.api.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilot.api.member.entity.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	public Member findByMemberIdAndPasswd(String memberId, String passwd);
	
	public Optional<Member> findByMemberId(String memberId);
	
	public List<Member> findByRole(String role);
	
	public List<Member> findByState(String state);
	
}
