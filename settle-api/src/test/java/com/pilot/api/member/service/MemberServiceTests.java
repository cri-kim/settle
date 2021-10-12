package com.pilot.api.member.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import com.pilot.api.member.dto.MemberDto;
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
	void findAll(){
		List<Member> entityList = new ArrayList<>();
		Member member = Member.builder()
				.memberId("1").memberNm("test")
				.state("")
				.role("")
				.build();
		MemberDto dto = MemberDto.builder().memberId("1").memberNm("test")
				.state("")
				.role("")
				.build();
		entityList.add(member);
		when(memberRepository.findAll()).thenReturn(entityList);
		assertThat(memberService.findAll()).contains(dto);
	}
}
