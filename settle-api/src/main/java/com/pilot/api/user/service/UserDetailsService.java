package com.pilot.api.user.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pilot.api.user.domain.User;
import com.pilot.api.user.repository.UserRepository;
import com.pilot.common.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		return userRepository.findByUserId(userId)
				.map(u-> new com.pilot.api.user.domain.UserDetails(u, Collections.singleton(new SimpleGrantedAuthority(u.getRole()))))
				.orElseThrow(()->new UserNotFoundException(userId));
	}
	
	public Optional<User> findByUserId(String userId){
		return userRepository.findByUserId(userId);
	}

	public List<User> findAll(){
		return userRepository.findAll();
	}
}
