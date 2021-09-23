package com.pilot.common.config.security;


import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pilot.api.member.domain.Member;
import com.pilot.api.member.domain.UserDetails;
import com.pilot.api.member.service.UserDetailsService;
import com.pilot.common.util.TokenUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider{

	private final static long REFRESH_TOKEN_EXPIRED_MINUTES = 60;
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
		//FIXME
		String refreshToken = TokenUtils.generateJwtToken(Member.builder().memberId(userId).role("MEMBER").build(), REFRESH_TOKEN_EXPIRED_MINUTES);
		userDetails.setRefreshToken(refreshToken);
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
