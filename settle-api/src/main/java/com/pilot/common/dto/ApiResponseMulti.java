package com.pilot.common.dto;

import java.util.List;

import com.pilot.common.enums.ResponseCode;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponseMulti<T> {
	private String code;
	private String msg;
	private List<T> data;
	
	public ApiResponseMulti(List<T> data){
		this.data = data;
		this.code = ResponseCode.SUCCESS.getCode();
		this.msg = ResponseCode.SUCCESS.getTitle();
	}
	public ApiResponseMulti(ResponseCode code){
		this.code = code.getCode();
		this.msg = code.getTitle();
	}
	
	public ApiResponseMulti(List<T> data, ResponseCode code) {
		this.data = data;
		this.code = code.getCode();
		this.msg = code.getTitle();
	}
}
