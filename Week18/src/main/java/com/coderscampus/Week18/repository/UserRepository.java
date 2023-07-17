package com.coderscampus.Week18.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.Week18.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	// select * from users where username = :name
	List<User> findByUsername(String name);
	
	// select * from users where name = :name 
	List<User> findByName(String name);
	
	// select * from users where name = :name and username = :username
	List<User> findByNameAndUsername(String name, String username);
	
	// select * from users where createdDate between :startDate and :endDate
	List<User> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);
	
	// find exactly one user by username
	@Query ("select u from User u where u.username = :username")
	List<User> findExactlyOneUserByUsername(String username);
	
	// find all users by joining accounts and address
	@Query("select u from User u" + " left join fetch u.accounts" + " left join fetch u.address")
	Set<User> findAllUsersWithAccountsAndAddresses();
	
//	// find exactly one user by email
//	@Query ("select u from User u where u.email = :email")
//    List<User> findExactlyOneUserByEmail(String email);
//}
}
