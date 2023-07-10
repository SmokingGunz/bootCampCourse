package com.coderscampus.Week18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Week18.domain.User;
import com.coderscampus.Week18.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {

		return userRepo.findAll();
	}

}
