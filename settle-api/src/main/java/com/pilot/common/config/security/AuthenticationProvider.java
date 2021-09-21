package com.pilot.common.config.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pilot.api.user.domain.UserDetails;
import com.pilot.api.user.service.UserDetailsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider{

	private UserDetailsService userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
		
		String userId = token.getName();
		String passwd = (String) token.getCredentials();
		UserDetails userDetails = (UserDetails) userDetailsService.loadUserByUsername(userId);
		if(!bCryptPasswordEncoder.matches(passwd, userDetails.getPassword())) {
			log.error(userId +" invalid password");
			throw new BadCredentialsException(userId +" invalid password");
		}
		return new UsernamePasswordAuthenticationToken(userDetails, passwd, userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	public AuthenticationProvider(UserDetailsService userDetailsService,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

}
