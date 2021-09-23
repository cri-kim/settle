package com.pilot.common.util;

import java.time.LocalDateTime;

public class DateUtils {
	public final static String NORMAL_DATE_TIME_FORMAT = "YYYY-MM-dd hh:mm:ss";
	
	public static LocalDateTime getTodayDtm() {
		return LocalDateTime.now();
	}
}
