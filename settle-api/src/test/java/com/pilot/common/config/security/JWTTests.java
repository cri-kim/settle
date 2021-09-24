package com.pilot.common.config.security;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pilot.api.member.entity.Member;
import com.pilot.common.util.TokenUtils;

public class JWTTests {
	private String token;
	
	
	@BeforeEach
	public void setup() {
		String id = "test";
		Member user = Member.builder().memberId(id).role("MEMBER").build();
		token = TokenUtils.generateJwtToken(user);
		System.out.println(token);
	}
	
	@Test
	public void testValidate() {
		assertThat(TokenUtils.isValidToken(token));
	}
	
}
