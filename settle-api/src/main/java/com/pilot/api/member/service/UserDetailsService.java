package com.pilot.api.member.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pilot.api.member.domain.Member;
import com.pilot.api.member.domain.UserDetails;
import com.pilot.api.member.repository.MemberRepository;
import com.pilot.common.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		return memberRepository.findByMemberId(userId)
				.map(u-> new UserDetails(u, Collections.singleton(new SimpleGrantedAuthority(u.getRole()))))
				.orElseThrow(()->new UserNotFoundException(userId));
	}
	
	public Optional<Member> findByUserId(String userId){
		return memberRepository.findByMemberId(userId);
	}

	public List<Member> findAll(){
		return memberRepository.findAll();
	}
}
