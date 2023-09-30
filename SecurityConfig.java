package com.example.demo.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public UserDetailsService detailsService() {
//		UserDetails normalUser=User
//				.withUsername("normal")
//				.password("normal")
//				.roles("NORMAL")
//				.build();
	
	@Bean
	public UserDetailsService detailsService() {
		UserDetails normalUser=User
				.withUsername("user")
				.password(passwordEncoder().encode("mypassword"))
				.roles("USER")
				.build();
		
		UserDetails adminUser=User
				.withUsername("admin")
				.password(passwordEncoder().encode("mypassword"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(normalUser,adminUser);
		
			
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/alluser")
			.hasRole("ADMIN")
			.requestMatchers("/product")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin();
		
			return httpSecurity.build();
			}
}

