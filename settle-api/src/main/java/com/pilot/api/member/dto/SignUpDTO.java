package com.pilot.api.member.dto;

import lombok.Data;

@Data
public class SignUpDTO {
	private String memberId;
	private String memberNm;
	private String passwd;
	private String role;
	private String state;
}
