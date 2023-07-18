package com.coderscampus.Week18.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Week18.domain.Account;
import com.coderscampus.Week18.domain.Address;
import com.coderscampus.Week18.domain.User;
import com.coderscampus.Week18.repository.AccountRepository;
import com.coderscampus.Week18.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AccountRepository accountRepo;

	public Set<User> findAll() {

		return userRepo.findAllUsersWithAccountsAndAddresses();
	}

	public User findById(Long userId) {

		Optional<User> userOpt = userRepo.findById(userId);

		return userOpt.orElse(new User());
	}

	// method to save user and account information
	public User saveUser(User user) {

		if (user.getUserId() == null) {

			Account checking = new Account();
			checking.setAccountName("Checking Account");
			checking.getUsers().add(user);
			user.getAccounts().add(checking);
			accountRepo.save(checking);
			Account savings = new Account();
			savings.setAccountName("Savings Account");
			savings.getUsers().add(user);
			user.getAccounts().add(savings);
			accountRepo.save(savings);

		}
		// CascadeTypes => PERSIST, MERGE, REMOVE
		// PERSIST new User() <-> new Address() --> saveUser()
		// MERGE existingUser() -> new/updating Address() --> saveUser()
		// REMOVE existingUser() -> setAddress(null) --> saveUser

		if (user.getAddress() == null) {

			Address address = new Address();
			address.setAddressLine1("123 Fake Street");
			address.setAddressLine2("Unit 4");
			address.setCity("New York");
			address.setReqion("New York");
			address.setCountry("United States");
			address.setZipCode("123455");
			address.setUser(user);
			address.setUserId(user.getUserId());

			user.setAddress(address);
		}

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

	// method to find exactly one user by username
	public User findExactlyOneUserByUsername(String username) {

		List<User> users = userRepo.findByUsername(username);

		if (users.size() > 0)
			return users.get(0);
		else

			return new User();
	}

}
