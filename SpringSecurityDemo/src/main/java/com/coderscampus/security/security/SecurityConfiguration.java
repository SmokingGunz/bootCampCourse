package com.coderscampus.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.coderscampus.security.repository.UserRepository;
import com.coderscampus.security.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	private UserRepository userRepo;
	

	public SecurityConfiguration(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	// second step
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserService(passwordEncoder(), userRepo);
	}
	
	// this is the first step
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((request) -> {
			request.requestMatchers("/products").authenticated()  // this would permit access to authenticated users only
//			       .anyRequest().permitAll(); // this would permit all requests
			       .requestMatchers("/api/v1/users").permitAll(); // this would permit access to just this endpoint for all users
		})
//		.userDetailsService(userDetailsService())
		.authenticationProvider(authenticationProvider())
		.formLogin(Customizer.withDefaults());

// 		http.authorizeHttpRequests().requestMatchers("/public/**").permitAll().anyRequest()
// 				.hasRole("USER").and()
// 				// Possibly more configuration ...
// 				.formLogin() // enable form based log in
// 				// set permitAll for all URLs associated with Form Login
// 				.permitAll();
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
