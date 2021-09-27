package com.pilot.api.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;

@RestController
public class GlobalErrorController implements ErrorController{

	@RequestMapping(value = "/api/error")
	public ResponseEntity<ApiResponseSingle<String>> error(){
		ApiResponseSingle<String> body
		= new ApiResponseSingle<String>(ResponseCode.INTERNAL_SYSTEM_ERROR);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
	}
	
	@RequestMapping(value = "/api/error/client")
	public ResponseEntity<ApiResponseSingle<String>> badParameter(){
		ApiResponseSingle<String> body
		= new ApiResponseSingle<String>(ResponseCode.BAD_PARAMETER);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
	
	@RequestMapping(value = "/api/error/unauthorized")
	public ResponseEntity<ApiResponseSingle<String>> unauthorized(){
		ApiResponseSingle<String> body
		= new ApiResponseSingle<String>(ResponseCode.UNAUTHORIZED);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
	}
}
