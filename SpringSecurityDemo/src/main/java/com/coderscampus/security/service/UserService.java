package com.coderscampus.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coderscampus.security.domain.User;
import com.coderscampus.security.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		super();
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
