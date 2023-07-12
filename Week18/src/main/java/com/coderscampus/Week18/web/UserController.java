package com.coderscampus.Week18.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.Week18.domain.User;
import com.coderscampus.Week18.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String getAllUsers(ModelMap model) {
		List<User> users = userService.findAll();
		model.put("users", users);
		return "users";
	}

	@GetMapping("/users/{userId}")
	public String getUser(@PathVariable Long userId, ModelMap model) {

		User user = userService.findById(userId);

		model.put("users", Arrays.asList(user));

		return "users";
	}

	@GetMapping("/register")
	public String getCreateUser(ModelMap model) {

		model.put("user", new User());

		return "register";
	}

	@PostMapping("/register")
	public String postCreateUser(User user) {

		System.out.println(user);

		userService.createUser(user);

		return "redirect:/register";

	}
}
