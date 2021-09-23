package com.pilot.api.member.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilot.api.member.domain.Member;
import com.pilot.api.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public Optional<Member> findByUserId(String userId){
		return memberRepository.findByMemberId(userId);
	}

	public Member save(Member member) {
		return memberRepository.save(member);
	}
}
