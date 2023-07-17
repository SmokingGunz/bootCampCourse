package com.coderscampus.Week18.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
