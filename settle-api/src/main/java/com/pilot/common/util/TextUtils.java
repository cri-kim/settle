package com.pilot.common.util;

public class TextUtils {

	public static boolean containsKorean(String s) {
		if(s.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			return true;
		}
		return false;
	}
	
	public static boolean isOnlyNumber(String s) {
		if(s.matches("^[0-9]*$")) {
			return true;
		}
		return false;
	}
	
	public static boolean isOnlyEnglish(String s) {
		if(s.matches("^[a-zA-Z]*$")) {
			return true;
		}
		return false;
	}
	
	public static boolean isOnlyKorean(String s) {
		if(s.matches("^[가-힣]*")) {
			return true;
		}
		return false;
	}
	
	public static boolean isOnlyEnglishNNumber(String s) {
		if(s.matches("^[a-zA-Z0-9]*$")) {
			return true;
		}
		return false;
	}
}
