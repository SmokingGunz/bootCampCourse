package com.coderscampus.security.web;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.security.domain.User;
import com.coderscampus.security.repository.UserRepository;
import com.coderscampus.security.response.AuthenticationResponse;
import com.coderscampus.security.service.JwtService;
import com.coderscampus.security.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;
	private JwtService jwtService;
	private UserService userService;

	public UserController(UserRepository userRepo, PasswordEncoder passwordEncoder, JwtService jwtService,
			UserService userService) {
		super();
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.userService = userService;
	}

	@PostMapping("")
	public ResponseEntity<AuthenticationResponse> createUser(@RequestBody User user) {

//		User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()));

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User savedUser = userRepo.save(user);

		String accessToken = jwtService.generateToken(new HashMap<>(), savedUser);

		return ResponseEntity.ok(new AuthenticationResponse(savedUser.getUsername(), accessToken));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> singInUser(@RequestBody User user) {

		UserDetails loggedInUser = userService.loadUserByUsername(user.getUsername());

		String accessToken = jwtService.generateToken(new HashMap<>(), loggedInUser);

		return ResponseEntity.ok(new AuthenticationResponse(loggedInUser.getUsername(), accessToken));

	}
}
