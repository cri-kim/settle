package com.pilot.common.exception;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String userId){
		super(userId + " NotFoundException.");
	}
}
