package com.pilot.common.enums;

public enum ResponseCode implements EnumMapperType {

	SUCCESS("0000","Success"),
	BAD_PARAMETER("4000","Bad parameter"),
	UNAUTHORIZED("4001","Unauthorized"),
	NO_CODE("9999","No Code");
	
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
