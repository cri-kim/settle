package com.pilot.api.member.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pilot.api.member.entity.Member;
import com.pilot.api.member.repository.MemberAuthRepository;
import com.pilot.api.member.repository.MemberRepository;

public class MemberServiceTests {

	private MemberRepository memberRepository = Mockito.mock(MemberRepository.class);
	private MemberAuthRepository authRepository = Mockito.mock(MemberAuthRepository.class);
	MemberService memberService ;
	
	@BeforeEach
	private void setUp() {
		memberService = new MemberService(memberRepository,authRepository);
	}
	
	@Test
	public void save() {
		Member dto = new Member(null, "test3", "Test3", "MEMBER", "test3", "Y");

		when(memberRepository.save(dto)).thenReturn(dto);
		Member newOne = memberService.save(dto);

		assertEquals(newOne.getMemberNm(), "test3");
	}
}
