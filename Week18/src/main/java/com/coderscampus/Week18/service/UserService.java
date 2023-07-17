package com.coderscampus.Week18.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

	public User findById(Long userId) {

		Optional<User> userOpt = userRepo.findById(userId);

		return userOpt.orElse(new User());
	}

	public User saveUser(User user) {

		return userRepo.save(user);
	}

	public void delete(Long userId) {

		userRepo.deleteById(userId);
	}

	 // method to find user by username
    public List<User> findByUsername(String username) {

        return userRepo.findByUsername(username);
    }
    
    // method to find by username and name
    public List<User> findByNameAndUsername(String name, String username) {

        return userRepo.findByNameAndUsername(name, username);
    }
    
    // method to find by date between
    public List<User> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate) {

        return userRepo.findByCreatedDateBetween(startDate, endDate);
    }

}
