package com.pilot.api.member.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.common.dto.ApiResponseMulti;
import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@RequestMapping(value="/add")
	public ResponseEntity<ApiResponseSingle<String>> add(){
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<ApiResponseSingle<String>>(body, header, HttpStatus.OK);
	}
	
	@RequestMapping(value="/list")
	public ResponseEntity<ApiResponseMulti<String>> list(){
		ApiResponseMulti<String> body = new ApiResponseMulti<String>(ResponseCode.SUCCESS);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<ApiResponseMulti<String>>(body, header, HttpStatus.OK);
	}
	
	@RequestMapping(value="/info")
	public ResponseEntity<ApiResponseSingle<String>> info(){
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<ApiResponseSingle<String>>(body, header, HttpStatus.OK);
	}
	
	@RequestMapping(value="/auth/list")
	public ResponseEntity<ApiResponseMulti<String>> authList(){
		ApiResponseMulti<String> body = new ApiResponseMulti<String>(ResponseCode.SUCCESS);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<ApiResponseMulti<String>>(body, header, HttpStatus.OK);
	}
	
	@RequestMapping(value="/auth/mod")
	public ResponseEntity<ApiResponseSingle<String>> authMod(){
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<ApiResponseSingle<String>>(body, header, HttpStatus.OK);
	}
}
