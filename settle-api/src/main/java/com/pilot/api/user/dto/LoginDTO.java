package com.pilot.api.user.dto;

import lombok.Data;

@Data
public class LoginDTO {
	private String userId;
	private String passwd;
}
