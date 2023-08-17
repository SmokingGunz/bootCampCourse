package com.coderscampus.Week21.web;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Week21.domain.User;

@RestController
@RequestMapping("/user")
public class UserConroller {

	@GetMapping("/exists")
	public Boolean exists(String username, String password) {

		System.out.println("Username: " + username + " Password: " + password);

		return true;
	}

	@PostMapping("/exists")
	public Boolean postExists(@RequestBody User user) {

		System.out.println("Username: " + user.getUsername() + " Password: " + user.getPassword());

		return true;
	}

	@GetMapping("/validateusername")
	public Boolean validateUsername(String username) {
		return false;
	}

	@GetMapping("/validatepassword")
	public Boolean validatePassword(String password) {
		return false;
	}

	@GetMapping("/register")
	public String getCreateUser(ModelMap model) {

		model.put("user", new User());

		return "register";
	}
	
//	@PostMapping("/register")
//	public String postCreateUser(User user) {
//		System.out.println(user);
//		userService.saveUser(user);
//		return "redirect:/register";
//	}

}
