package com.pilot.common.config.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.pilot.common.constant.AuthConstants;
import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;
import com.pilot.api.member.domain.UserDetails;
import com.pilot.common.util.TokenUtils;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		UserDetails user = ((UserDetails)authentication.getPrincipal());
		String refreshToken = user.getRefreshToken();
		
		String token= TokenUtils.generateJwtToken(user.getUser());
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

		//refresh token cookie 삽입
		Cookie cookie = new Cookie("refreshToken", refreshToken);
		cookie.setMaxAge(60 * 60);
//		cookie.setSecure(true);
//		cookie.setPath(uri);
		response.addCookie(cookie);
		
		//header에 token 삽입
		response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_PREFIX + " "+ token);

		//json 성공 응답
		MappingJackson2HttpMessageConverter jsonConterver = new MappingJackson2HttpMessageConverter();
		MediaType contentType = MediaType.APPLICATION_JSON;
		ApiResponseSingle<String> dto = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		jsonConterver.write(dto, contentType, new ServletServerHttpResponse(response));
		
	}
}
