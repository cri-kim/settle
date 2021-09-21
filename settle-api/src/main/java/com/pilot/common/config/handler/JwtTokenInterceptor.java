package com.pilot.common.config.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.pilot.common.constant.AuthConstants;
import com.pilot.common.util.TokenUtils;

public class JwtTokenInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String header = request.getHeader(AuthConstants.AUTH_HEADER);
		
		if(header != null) {
			String token = TokenUtils.getTokenFromHeader(header);
			if(TokenUtils.isValidToken(token)) {
				return true;
			}
		}
		response.sendRedirect("/error/unauthorized");
		return false;
	}
}
