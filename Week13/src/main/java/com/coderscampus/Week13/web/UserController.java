package com.coderscampus.Week13.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Week13.service.UserService;

@RestController
public class UserController {

//	@Autowired
//	private UserService userService;  // This would work but we are going to do Constructor based Autowiring 

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public String getUsers() {
		return userService.getMessage();
	}

}
