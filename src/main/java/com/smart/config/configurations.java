package com.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.FilterChain;

@EnableWebSecurity
@Configuration
public class configurations {

	@Bean
	PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	UserDetailsService userDetailsService() {

		return new custemUserDetailService();
	}

	@Bean
	AuthenticationProvider provider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(encoder());
		provider.setUserDetailsService(userDetailsService());
	 
		return provider;
	}

//	
//	@Bean
//	UserDetailsService userDetailsService() {
//		UserDetails user1 = User.withUsername("manash@gmail").password("123").roles("user").build();
//		UserDetails user2 = User.withUsername("ramesh").password("123").roles("user").build();
//		UserDetails user3 = User.withUsername("ncsusant@gmail").password("123").roles("user").build();
//		UserDetails user4 = User.withUsername("laxmi").password("123").roles("user").build();
//		
//		
//		InMemoryUserDetailsManager manager = new  InMemoryUserDetailsManager(user1,user2,user3,user4);
//	 
//		
//		
//		return manager;
//	}
//	

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(e -> {
			e.disable();
		}).authorizeHttpRequests(e -> {
			e.requestMatchers("/home", "/login", "/signup", "/processuser", "/about", "/css/**", "/images/**",
					"/javascript/**").permitAll().requestMatchers("/user/**").authenticated();

		}).formLogin(e -> {
			e.loginPage("/login").usernameParameter("email")

					.loginProcessingUrl("/login").defaultSuccessUrl("/user/");
		})

		;

		return http.build();
	}

}
