package com.coderscampus.security.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.security.domain.User;
import com.coderscampus.security.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;

	public UserController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		super();
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("")
	public ResponseEntity<User> createUser(User user) {

		User newUser = new User(user.getPassword(), passwordEncoder.encode(user.getPassword()));

		User savedUser = userRepo.save(newUser);

		return ResponseEntity.ok(savedUser);
	}
}
