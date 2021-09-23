package com.pilot.common.enums;

public enum ResponseCode implements EnumMapperType {

	SUCCESS("0000","Success"),
	BAD_PARAMETER("4000","Bad parameter"),
	UNAUTHORIZED("4001","Unauthorized"),
	
	INTERNAL_SYSTEM_ERROR("9999","System maintenance");
	
	private String code;
	private String title;
	
	ResponseCode(String title, String code){
		this.title = title;
		this.code = code;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getTitle() {
		return title;
	}
}
