package com.pilot.api.member.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.api.member.dto.UserAuthDTO;
import com.pilot.api.member.entity.MemberAuth;
import com.pilot.api.member.service.MemberService;
import com.pilot.common.dto.ApiResponseMulti;
import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;
/**
 * Author : cri
 * Description : 사용자 권한 정보 api
*/
@RestController
@RequestMapping(value="/api/auth")
public class AuthController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/list")
	public ResponseEntity<ApiResponseMulti<MemberAuth>> getList(@RequestBody UserAuthDTO dto) {
		ApiResponseMulti<MemberAuth> body = new ApiResponseMulti<MemberAuth>(ResponseCode.SUCCESS);
		
		if(StringUtils.isNotBlank(dto.getMemberId())) {
			body.setData(memberService.findByMemberIdAuthList(dto.getMemberId()));
		}
		else if(StringUtils.isNotBlank(dto.getAuthKey())) {
			body.setData(memberService.findByAuthKeyMemberAuthList(Long.parseLong(dto.getAuthKey())));
		}
		else {
			body.setData(memberService.findAllMemberAuthList());
		}
		return new ResponseEntity<ApiResponseMulti<MemberAuth>>(body, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add")
	public ResponseEntity<ApiResponseSingle<String>> add(@RequestBody UserAuthDTO dto) {
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		memberService.saveMemberAuth(dto.getMemberId(), dto.getAuthKey());
		return new ResponseEntity<ApiResponseSingle<String>>(body,  HttpStatus.OK);
	}
	
	@RequestMapping(value="/mod")
	public ResponseEntity<ApiResponseSingle<String>> mod(@RequestBody UserAuthDTO dto) {
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		memberService.updateMemberAuth(dto);
		return new ResponseEntity<ApiResponseSingle<String>>(body,  HttpStatus.OK);
	}
}
