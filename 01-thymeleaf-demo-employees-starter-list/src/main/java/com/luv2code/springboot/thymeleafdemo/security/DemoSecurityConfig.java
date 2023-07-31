package com.luv2code.springboot.thymeleafdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails shraddha = User.builder()
				.username("shraddha")
						.password("{noop}shraddha")
								.roles("Admin")
										.build();
						
		UserDetails rajesh = User.builder()
				.username("rajesh")
						.password("{noop}rajesh")
								.roles("User")
										.build();
		return new InMemoryUserDetailsManager(shraddha, rajesh);
	
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> 
		configurer
		.requestMatchers("/showAdminIndex/**").hasRole("Admin")
		.requestMatchers("/showUserIndex/**").hasRole("User")
		.anyRequest()
		.authenticated()
		)
		.formLogin(
				form -> 
				form
				.loginPage("/showLoginForm")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				)
		.logout(
				logout->
				logout
				.permitAll()
				);
		return http.build();
	}

}