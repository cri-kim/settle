package com.pilot.api.member.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;


@RestController
public class LoginController {
	
	@RequestMapping(value="/api/login/refresh")
	public ResponseEntity<ApiResponseSingle<String>> refresh(){
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		HttpHeaders header = new HttpHeaders();
//		header.add("token", TokenUtils.generateJwtToken(user));
		return new ResponseEntity<ApiResponseSingle<String>>(body, header, HttpStatus.OK);
	}
}
