package com.pilot.common.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pilot.api.member.service.UserDetailsService;
import com.pilot.common.config.filter.AuthenticationFilter;
import com.pilot.common.config.filter.JwtFilter;
import com.pilot.common.config.handler.LoginFailureHandler;
import com.pilot.common.config.handler.LoginSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	// Ignore security confing to static resource
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic().disable()
		.csrf().disable()
		.exceptionHandling()
		.accessDeniedHandler(accessDeniedHandler())
		.authenticationEntryPoint(authenticationEntryPoint())
		
		.and()
		.authorizeRequests()
			.antMatchers("/api/login/**","/error/**").permitAll()
			.anyRequest().authenticated()
		.and()
		.logout()
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.permitAll()
		.and()
		.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
		;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtFilter jwtFilter() throws Exception{
		JwtFilter filter= new JwtFilter();
		return filter;
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest request, HttpServletResponse response,
					AccessDeniedException accessDeniedException) throws IOException, ServletException {
				response.sendRedirect("/error/unauthorized");
			}
		};
	}
	
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationEntryPoint() {
			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {
				response.sendRedirect("/error/unauthorized");
			}
		};
	}
	
	@Bean
	public AuthenticationFilter authenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager());
		authenticationFilter.setFilterProcessesUrl("/login");
		authenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler());
		authenticationFilter.setAuthenticationFailureHandler(loginFailureHandler());
		authenticationFilter.afterPropertiesSet();
		return authenticationFilter;
	}
	
	@Bean
	public LoginSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}
	
	@Bean
	public LoginFailureHandler loginFailureHandler() {
		return new LoginFailureHandler();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new AuthenticationProvider(userDetailsService, bCryptPasswordEncoder());
	}
	
}
