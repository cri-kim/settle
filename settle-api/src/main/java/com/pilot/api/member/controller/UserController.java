package com.pilot.api.member.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.api.member.entity.Member;
import com.pilot.api.member.dto.SignUpDTO;
import com.pilot.api.member.dto.UserDTO;
import com.pilot.api.member.service.MemberService;
import com.pilot.common.dto.ApiResponseMulti;
import com.pilot.common.dto.ApiResponseSingle;
import com.pilot.common.enums.ResponseCode;
/**
 * Author : cri
 * Description : 사용자 정보 api
*/
@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="/add")
	public ResponseEntity<ApiResponseSingle<String>> add(@RequestBody SignUpDTO dto){
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);

		Member newMemeber = memberService.save(Member.builder().memberId(dto.getMemberId()).memberNm(dto.getMemberNm())
				.passwd(bCryptPasswordEncoder.encode(dto.getPasswd()))
				.state(dto.getState())
				.role(dto.getRole())
				.build());
		
		if(newMemeber == null) {
			return new ResponseEntity<ApiResponseSingle<String>>(new ApiResponseSingle<String>(ResponseCode.BAD_PARAMETER),  HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ApiResponseSingle<String>>(body, HttpStatus.OK);
	}
	
	@RequestMapping(value="/list")
	public ResponseEntity<ApiResponseMulti<UserDTO>> list(@RequestBody UserDTO dto){
		ApiResponseMulti<UserDTO> body = new ApiResponseMulti<UserDTO>(ResponseCode.SUCCESS);
		
		if(StringUtils.isNotBlank(dto.getMemberId())) {
			List<UserDTO> list = new ArrayList<UserDTO>();
			Optional<Member> member =  memberService.findByMemberId(dto.getMemberId());
			
			if(member.isPresent()) {
				list.add(new UserDTO(member.get()));
			}
			body.setData(list);
		}
		else if(StringUtils.isNotBlank(dto.getRole())) {
			List<UserDTO> list = memberService.findByRole(dto.getRole())
					.stream().map(u->new UserDTO(u)).collect(Collectors.toCollection(ArrayList::new));
					body.setData(list);
		}
		else if(StringUtils.isNotBlank(dto.getState())) {
			List<UserDTO> list = memberService.findByState(dto.getState())
					.stream().map(u-> new UserDTO(u)).collect(Collectors.toCollection(ArrayList::new));
					body.setData(list);
		}
		else {
			List<UserDTO> list = memberService.findAll().stream().map(u->
					new UserDTO(u)).collect(Collectors.toCollection(ArrayList::new));
					body.setData(list);
		}
		return new ResponseEntity<ApiResponseMulti<UserDTO>>(body, HttpStatus.OK);
	}
	
	@RequestMapping(value="/info")
	public ResponseEntity<ApiResponseSingle<UserDTO>> info(@RequestBody UserDTO dto){
		ApiResponseSingle<UserDTO> body = new ApiResponseSingle<UserDTO>(ResponseCode.BAD_PARAMETER);
		Optional<Member> member =  memberService.findByMemberId(dto.getMemberId());
		if(member.isPresent()) {
			body =  new ApiResponseSingle<UserDTO>(new UserDTO(member.get()),ResponseCode.SUCCESS);
		}
		
		return new ResponseEntity<ApiResponseSingle<UserDTO>>(body, HttpStatus.OK);
	}
	
	@RequestMapping(value="/mod")
	public ResponseEntity<ApiResponseSingle<String>> mod(@RequestBody SignUpDTO dto) {
		ApiResponseSingle<String> body = new ApiResponseSingle<String>(ResponseCode.SUCCESS);
		memberService.update(new Member(null, dto.getMemberId(), dto.getPasswd(), dto.getRole()
				, dto.getMemberNm(), dto.getState()));
		return new ResponseEntity<ApiResponseSingle<String>>(body, HttpStatus.OK);
	}
	
}
