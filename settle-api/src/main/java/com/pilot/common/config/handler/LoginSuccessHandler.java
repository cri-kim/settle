package com.pilot.common.config.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.pilot.common.constant.AuthConstants;
import com.pilot.api.user.domain.User;
import com.pilot.api.user.domain.UserDetails;
import com.pilot.common.util.TokenUtils;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	/*
	 * @Override public void setDefaultTargetUrl(String defaultTargetUrl) {
	 * super.setDefaultTargetUrl(defaultTargetUrl); }
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		User user = ((UserDetails)authentication.getPrincipal()).getUser();
		String token= TokenUtils.generateJwtToken(user);
		response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_TYPE + " "+ token);
	}
}
