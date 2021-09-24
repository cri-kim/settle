package com.pilot.api.member.dto;

import lombok.Data;

@Data
public class UserAuthDTO {
	private String memberId;
	private String authKey;
	private String useYn;
}
