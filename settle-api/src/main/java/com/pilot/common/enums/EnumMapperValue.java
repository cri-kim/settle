package com.pilot.common.enums;

public class EnumMapperValue {
	private String code;
	private String title;
	
	public EnumMapperValue(EnumMapperType type) {
		code = type.getCode();
		title = type.getTitle();
	}
	
	@Override
	public String toString() {
		return "{" +
					"code="+code+'\''+
					", title="+ title +'\''+
				'}';
	}
	
}
