package com.pilot.api.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.api.user.domain.User;
import com.pilot.api.user.dto.SignUpDTO;
import com.pilot.api.user.service.UserDetailsService;
import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;
import com.pilot.common.util.TokenUtils;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value = "/signup")
	public ResponseEntity<ApiResponseSingle<String>> signUp(SignUpDTO signUpDto){
		Optional<User> user= userDetailsService.findByUserId(signUpDto.getUserId());
		if(user.isPresent()) {
			ApiResponseSingle<String> body
			= new ApiResponseSingle<String>(TokenUtils.generateJwtToken(user.get()));
			return ResponseEntity
					.ok(body);
		}
		else {
			ApiResponseSingle<String> body
			= new ApiResponseSingle<String>(ResponseCode.BAD_PARAMETER);
			return ResponseEntity.badRequest().body(body);
		}
	}
}
