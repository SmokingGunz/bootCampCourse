package com.coderscampus.Week18.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // This represents an entity in the database
@Table(name = "users") // because user is a reserved table in the database we have to use this name and annotation type
public class User {

	@Id  // this makes the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // this automatically generates the primary key
	private Long userId;
	private String username;
	private String password;
	private String name;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + "]";
	}
}
