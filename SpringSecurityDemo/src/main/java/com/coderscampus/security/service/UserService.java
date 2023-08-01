package com.coderscampus.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.coderscampus.security.domain.User;
import com.coderscampus.security.repository.UserRepository;

public class UserService implements UserDetailsService {

	private PasswordEncoder passwordEncoder;

	private UserRepository userRepo;

	public UserService(PasswordEncoder passwordEncoder, UserRepository userRepo) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userRepo = userRepo;
	}

	// this is the second step
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		return user;
	}
	
	

}
