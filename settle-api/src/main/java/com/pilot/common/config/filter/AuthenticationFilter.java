package com.pilot.common.config.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pilot.api.user.domain.User;

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

		try {
			User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

			log.info("{} : login attemp", user.getUserId());
			authRequest = new UsernamePasswordAuthenticationToken(user.getUserId(), user.getPasswd());
			setDetails(request, authRequest);
			
		} catch (IOException e) {
//			e.printStackTrace();
		}

		return this.getAuthenticationManager().authenticate(authRequest);
	}
}
