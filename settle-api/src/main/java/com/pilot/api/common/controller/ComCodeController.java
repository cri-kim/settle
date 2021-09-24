package com.pilot.api.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;

@RestController
@RequestMapping(value="/api/code")
public class ComCodeController {

	
	@RequestMapping(value="/auth")
	public ResponseEntity<ApiResponseSingle<String>> getAuth(){
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		return new ResponseEntity<ApiResponseSingle<String>>(body, HttpStatus.OK);
	}
	
	@RequestMapping(value="/payment")
	public ResponseEntity<ApiResponseSingle<String>> getPayment(){
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		return new ResponseEntity<ApiResponseSingle<String>>(body, HttpStatus.OK);
	}
}
