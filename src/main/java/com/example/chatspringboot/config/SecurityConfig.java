package com.example.chatspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.chatspringboot.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {
	
	@Bean
	protected BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected UserDetailsService userDetailsServiceImpl() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	protected DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetailsServiceImpl());
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Bean
	protected SecurityFilterChain config(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests()
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET, "/start").permitAll()
				.antMatchers(HttpMethod.POST, "/start").permitAll()
				.antMatchers(HttpMethod.GET, "/chat").hasAnyAuthority("ADMIN", "USER")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.usernameParameter("username")
				.defaultSuccessUrl("/chat")
				.permitAll();
		
		return http.build();
	}
}
