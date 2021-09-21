package com.pilot.common.dto;

import com.pilot.common.enums.ResponseCode;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponseSingle<T> {
	private String code;
	private String msg;
	private T data;
	
	public ApiResponseSingle(T data){
		this.data = data;
		this.code = ResponseCode.SUCCESS.getCode();
		this.msg = ResponseCode.SUCCESS.getTitle();
	}
	public ApiResponseSingle(ResponseCode code){
		this.code = code.getCode();
		this.msg = code.getTitle();
	}
	
	public ApiResponseSingle(T data, ResponseCode code) {
		this.data = data;
		this.code = code.getCode();
		this.msg = code.getTitle();
	}
}
