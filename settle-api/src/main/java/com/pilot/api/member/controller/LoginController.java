package com.pilot.api.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.api.member.entity.UserDetails;
import com.pilot.api.member.dto.RefreshDTO;
import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;
import com.pilot.common.util.TokenUtils;


@RestController
public class LoginController {
	
	@RequestMapping(value="/api/login/refresh")
	public ResponseEntity<ApiResponseSingle<String>> refresh(@RequestBody RefreshDTO dto, HttpServletRequest request){
		UserDetails userDetails = ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		//FIXME refresh token 체크/갱신 필요
		String refreshToken = StringUtils.defaultString(userDetails.getRefreshToken());
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		
		//Check refreshToken
		if(!TokenUtils.isValidToken(dto.getRefreshToken()) || !dto.getRefreshToken().equals(refreshToken)) {
			return new ResponseEntity<ApiResponseSingle<String>>(new ApiResponseSingle<String>(ResponseCode.BAD_PARAMETER), HttpStatus.BAD_REQUEST);
		}
		
		//refresh accessToken 
		HttpHeaders header = new HttpHeaders();
		header.add("token", TokenUtils.generateJwtToken(userDetails.getUser()));
		return new ResponseEntity<ApiResponseSingle<String>>(body, header, HttpStatus.OK);
	}
}
