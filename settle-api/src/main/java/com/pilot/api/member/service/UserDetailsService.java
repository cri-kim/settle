package com.pilot.api.member.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pilot.api.member.entity.UserDetails;
import com.pilot.api.member.repository.MemberRepository;
import com.pilot.common.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		return memberRepository.findByMemberId(userId)
				.map(u-> new UserDetails(u, Collections.singleton(new SimpleGrantedAuthority(u.getRole()))))
				.orElseThrow(()->new UserNotFoundException(userId));
	}
}
