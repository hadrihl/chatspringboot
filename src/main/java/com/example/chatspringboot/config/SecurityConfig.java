package com.example.chatspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	protected SecurityFilterChain config(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests()
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET, "/start").permitAll()
				.antMatchers(HttpMethod.POST, "/start").permitAll()
				.antMatchers(HttpMethod.GET, "/chat").permitAll()
				.anyRequest().authenticated();
		
		return http.build();
	}
}
