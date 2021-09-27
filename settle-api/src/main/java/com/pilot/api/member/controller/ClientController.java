package com.pilot.api.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.api.member.service.MemberService;
/**
 * Author : cri
 * Description : 사용자정보 api
*/
@RestController
@RequestMapping(value="/api/client")
public class ClientController {
	
	@Autowired
	private MemberService memberService;
	
}
