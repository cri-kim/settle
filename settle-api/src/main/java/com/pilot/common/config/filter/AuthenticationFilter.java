package com.pilot.common.config.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pilot.api.member.dto.LoginDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public AuthenticationFilter(AuthenticationManager manager) {
		super.setAuthenticationManager(manager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		UsernamePasswordAuthenticationToken authRequest = null;
		String userId = "";
		try {
			LoginDTO user = new ObjectMapper().readValue(request.getInputStream(), LoginDTO.class);
			userId = StringUtils.defaultString(user.getMemberId());
			log.info("{} : login attemp", userId);
			authRequest = new UsernamePasswordAuthenticationToken(userId, user.getPasswd());
			setDetails(request, authRequest);
			
		} catch (IOException e) {
//			e....
		}

		return this.getAuthenticationManager().authenticate(authRequest);
	}
}
