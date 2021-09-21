package com.pilot.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;
import com.pilot.common.util.TokenUtils;

@RestController
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping(value = "/")
	public ResponseEntity<ApiResponseSingle<String>> error(){
		ApiResponseSingle<String> body
		= new ApiResponseSingle<String>(ResponseCode.NO_CODE);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
	}
	
	@RequestMapping(value = "/unauthorized")
	public ResponseEntity<ApiResponseSingle<String>> unauthorized(){
		ApiResponseSingle<String> body
		= new ApiResponseSingle<String>(ResponseCode.UNAUTHORIZED);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
	}
}
