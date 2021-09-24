package com.pilot.common.util;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ObjectUtils {

	public static void copyNotNullProperties(Object source, Object target) {
		BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
	}
	
	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		PropertyDescriptor[] pds = src.getPropertyDescriptors();
		
		Set<String> emptyNames = new HashSet<String>();
		for(PropertyDescriptor pd: pds) {
			Object value = src.getPropertyValue(pd.getName());
			if(value == null) {
				emptyNames.add(pd.getName());
			}
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}
}
