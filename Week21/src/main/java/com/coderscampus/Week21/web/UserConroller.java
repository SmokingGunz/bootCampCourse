package com.coderscampus.Week21.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.Week21.domain.User;
import com.coderscampus.Week21.service.UserService;

@Controller
@RequestMapping("/user")
public class UserConroller {
	
	@Autowired
    private UserService userService;

//	@GetMapping("/exists")
//	
//	public Boolean exists(String username, String password) {
//
//		System.out.println("Username: " + username + " Password: " + password);
//
//		return true;
//	}

	@PostMapping("/exists")
	@ResponseBody
	public Boolean postExists(@RequestBody User user) {
		
		user = userService.findByUsername(user.getUsername());
		
		return (user != null);
	}

	@GetMapping("/validateusername")
	@ResponseBody
	public Boolean validateUsername(String username) {
		return false;
	}

	@GetMapping("/validatepassword")
	@ResponseBody
	public Boolean validatePassword(String password) {
		return false;
	}

	@GetMapping("/register")
	public String getCreateUser(ModelMap model) {

		model.put("user", new User());

		return "register";
	}
	
	@PostMapping("/register")
	public String postCreateUser(User user) {
		System.out.println(user);
		userService.save(user);
		return "redirect:/login";
	}

}
