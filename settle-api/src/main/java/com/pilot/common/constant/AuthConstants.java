package com.pilot.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthConstants {
	public static final String AUTH_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "BEARER";
}
