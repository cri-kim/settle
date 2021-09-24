package com.pilot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class SettleApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SettleApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SettleApplication.class);
	}

}
