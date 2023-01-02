package com.coderscampus.lesson3;

// POJO = Plain Old Java Object

public class User {

	// instance variables (declared as private)
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int unsuccessfullLoginAttempts;

	
	// right click and go to source > generate getters and setters
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getUnsuccessfullLoginAttempts() {
		return unsuccessfullLoginAttempts;
	}

	public void setUnsuccessfullLoginAttempts(int unsuccessfullLoginAttempts) {
		this.unsuccessfullLoginAttempts = unsuccessfullLoginAttempts;
	}

	// getters and setters for the above instance variables
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", unsuccessfullLoginAttempts=" + unsuccessfullLoginAttempts + "]";
	}
}
