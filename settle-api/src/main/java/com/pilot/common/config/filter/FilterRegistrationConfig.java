package com.pilot.common.config.filter;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegistrationConfig {
	@Bean
	public FilterRegistrationBean<Filter> setJwtFilterBean() {
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<Filter>();
		bean.setFilter(new JwtFilter());
		bean.addUrlPatterns("/*");
		return bean;
	}
	
	@Bean
	public FilterRegistrationBean<Filter> setXSSFilterBean() {
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<Filter>();
		bean.setFilter(new XSSFilter());
		bean.addUrlPatterns("/*");
		return bean;
	}
}
