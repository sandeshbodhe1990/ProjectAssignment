package com.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private AuthenticationFilter apiKeyAuthFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
				.addFilterBefore(apiKeyAuthFilter, UsernamePasswordAuthenticationFilter.class)
				.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated());
		/*
		 * .headers(httpSecurityHeadersConfigurer -> {
		 * httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> {
		 * frameOptionsConfig.disable(); }); });
		 */
		return http.build();

	}
}
