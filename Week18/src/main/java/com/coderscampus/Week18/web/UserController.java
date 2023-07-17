package com.coderscampus.Week18.web;

import java.util.Arrays;
import java.util.Set;

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
//		List<User> users = userService.findByNameAndUsername("John", "john@doe.com");
//		List<User> users = userService.findByCreatedDateBetween(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1));
		
		Set<User> users = userService.findAll();
		model.put("users", users);
		
		if (users.size() == 1) {
			model.put("user", users.iterator().next());
		}
		return "users";
	}

	@GetMapping("/users/{userId}")
	public String getUser(@PathVariable Long userId, ModelMap model) {
		
		// find exactly one user by username
//		User user = userService.findExactlyOneUserByUsername("john@doe.com");

		User user = userService.findById(userId);

		model.put("users", Arrays.asList(user));
		model.put("user", user);

		return "users";
	}

	@PostMapping("/users/{userId}")
	public String postUser(@PathVariable Long userId, User user) {

		userService.saveUser(user);

		return "redirect:/users/" + userId;
	}

	@PostMapping("/users/{userId}/delete") // its listening for a post request to this URL then it will delete the user
	public String deleteUser(@PathVariable Long userId) {

		userService.delete(userId);

		return "redirect:/users";
	}

	@GetMapping("/register")
	public String getCreateUser(ModelMap model) {

		model.put("user", new User());

		return "register";
	}

	@PostMapping("/register")
	public String postCreateUser(User user) {

		System.out.println(user);

		userService.saveUser(user);

		return "redirect:/register";

	}

}
