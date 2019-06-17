package com.mclient.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mclient.web.exception.CustomErrorDecoder;

@Configuration
public class FeignExceptionConfig {
	@Bean
	public CustomErrorDecoder mCustomErrorDecoder() {
		return new CustomErrorDecoder();
	}
}
