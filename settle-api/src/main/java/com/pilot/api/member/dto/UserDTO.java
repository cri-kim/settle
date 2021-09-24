package com.pilot.api.member.dto;

import com.pilot.api.member.entity.Member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	private String memberId;
	private String memberNm;
	private String role;
	private String state;
	
	public UserDTO(Member member) {
		this.memberId = member.getMemberId();
		this.memberNm = member.getMemberNm();
		this.state = member.getState();
		this.role = member.getRole();
	}
}
