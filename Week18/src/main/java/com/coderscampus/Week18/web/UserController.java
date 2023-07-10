package com.coderscampus.Week18.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.Week18.domain.User;
import com.coderscampus.Week18.service.UserService;

@Controller
public class UserController {

	@Autowired
    private UserService userService;
	
	@GetMapping("/all-users")
	public String getAllUsers(ModelMap model) {
		List<User> users = userService.findAll();
        model.put("users", users);
        return "users";
    }
}
