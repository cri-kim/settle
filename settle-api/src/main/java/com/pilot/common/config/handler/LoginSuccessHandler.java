package com.pilot.common.config.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.pilot.common.constant.AuthConstants;
import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;
import com.pilot.api.member.domain.Member;
import com.pilot.api.member.domain.UserDetails;
import com.pilot.common.util.TokenUtils;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	private final static long REFRESH_TOKEN_EXPIRED_MINUTES = 60;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		Member user = ((UserDetails)authentication.getPrincipal()).getUser();
		
		String token= TokenUtils.generateJwtToken(user);
		String refreshToken= TokenUtils.generateJwtToken(user, REFRESH_TOKEN_EXPIRED_MINUTES);
		
		//refreshToken 세션 저장 
		//FIXME 캐시 db 저장하면 좋을 듯
		HttpSession session = request.getSession();
		session.setAttribute("refreshToken", refreshToken);
		
		//header에 token 삽입
		response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_PREFIX + " "+ token);

		//json 성공 응답
		MappingJackson2HttpMessageConverter jsonConterver = new MappingJackson2HttpMessageConverter();
		MediaType contentType = MediaType.APPLICATION_JSON;
		ApiResponseSingle<String> dto = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		jsonConterver.write(dto, contentType, new ServletServerHttpResponse(response));
		
	}
}
