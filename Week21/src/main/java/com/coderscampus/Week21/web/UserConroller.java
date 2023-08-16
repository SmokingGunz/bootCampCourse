package com.coderscampus.Week21.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserConroller {

	@GetMapping("/exists")
	public boolean exists(String username) {
		return false;
	}

	@GetMapping("/validateusername")
	public boolean validateUsername(String username) {
		return false;
	}

	@GetMapping("/validatepassword")
	public boolean validatePassword(String password) {
		return false;
	}

}
