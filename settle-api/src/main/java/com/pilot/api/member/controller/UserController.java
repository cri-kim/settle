package com.pilot.api.member.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.api.member.domain.Member;
import com.pilot.api.member.dto.UserAuthDTO;
import com.pilot.api.member.dto.UserDTO;
import com.pilot.api.member.service.MemberService;
import com.pilot.common.dto.ApiResponseMulti;
import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;
import com.pilot.common.util.DateUtils;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="/add")
	public ResponseEntity<ApiResponseSingle<String>> add(@RequestBody UserDTO dto){
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);

		Member newMemeber = memberService.save(Member.builder().memberId(dto.getMemberId()).memberNm(dto.getMemberNm())
				.passwd(bCryptPasswordEncoder.encode(dto.getPasswd()))
				.state("Y")
				.role(dto.getRole())
				.regDtm(DateUtils.getTodayDtm()).build());
		
		if(newMemeber == null) {
			return new ResponseEntity<ApiResponseSingle<String>>(new ApiResponseSingle<String>(ResponseCode.BAD_PARAMETER),  HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ApiResponseSingle<String>>(body, HttpStatus.OK);
	}
	
	@RequestMapping(value="/list")
	public ResponseEntity<ApiResponseMulti<String>> list(UserDTO dto){
		ApiResponseMulti<String> body = new ApiResponseMulti<String>(ResponseCode.SUCCESS);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<ApiResponseMulti<String>>(body, header, HttpStatus.OK);
	}
	
	@RequestMapping(value="/info")
	public ResponseEntity<ApiResponseSingle<String>> info(UserDTO dto){
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<ApiResponseSingle<String>>(body, header, HttpStatus.OK);
	}
	
	@RequestMapping(value="/auth/list")
	public ResponseEntity<ApiResponseMulti<String>> authList(UserAuthDTO dto){
		ApiResponseMulti<String> body = new ApiResponseMulti<String>(ResponseCode.SUCCESS);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<ApiResponseMulti<String>>(body, header, HttpStatus.OK);
	}
	
	@RequestMapping(value="/auth/mod")
	public ResponseEntity<ApiResponseSingle<String>> authMod(UserAuthDTO dto){
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<ApiResponseSingle<String>>(body, header, HttpStatus.OK);
	}
}
