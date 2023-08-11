package com.coderscampus.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.coderscampus.security.repository.UserRepository;
import com.coderscampus.security.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	private UserRepository userRepo;
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	

	public SecurityConfiguration(UserRepository userRepo, JwtAuthenticationFilter jwtAuthenticationFilter) {
		super();
		this.userRepo = userRepo;
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}

	// second step
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserService(userRepo);
	}
	
	// this is the first step
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((request) -> {
			request
//			       .requestMatchers("/products").authenticated()  // this would permit access to authenticated users only
//			       .anyRequest().permitAll(); // this would permit all requests
			       .requestMatchers("/api/v1/users").permitAll() // this would permit access to just this end point for all users
			       .anyRequest().authenticated(); // this would permit access to authenticated users only on all requests. Must be logged in to access all other end points. 
		})
		.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//		.userDetailsService(userDetailsService()) // moved this to the AuthenticationProvider method
		.authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
	
	// this is the third step
	@Bean
    public PasswordEncoder passwordEncoder() {		
        return new BCryptPasswordEncoder();
    }
	
	// this is the fourth step
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		return daoAuthenticationProvider;
	}

}
