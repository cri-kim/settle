package com.pilot.common.enums;

import java.util.*;

import lombok.Getter;
/*
 * ref : https://techblog.woowahan.com/2527/
 * 
 * */
@Getter
public enum PayGroup {
	
	CASH("현금", Arrays.asList("ACCOUNTS_TRANSFER","REMITTANCE","ON_SITE_PAYMENT","TOSS")),
	CARD("카드", Arrays.asList("PAYCO","CARD","NAVER_PAY","KAKAO_PAY","BADMIN_PAY")),
	ETC("기타", Arrays.asList("POINT","COUPON")),
	EMPTY("없음", Collections.emptyList());
	
	private String title;
	private List<String> payList;
	
	PayGroup(String title, List<String> payList){
		this.title = title;
		this.payList = payList;
	}
	
	public static PayGroup findByPayCode(String code) {
		return Arrays.stream(PayGroup.values())
				.filter(payGroup->payGroup.hasPayCode(code))
				.findAny()
				.orElse(EMPTY);
	}
	
	public boolean hasPayCode(String code) {
		return payList.stream().anyMatch(pay -> pay.equals(code));
	}
}
