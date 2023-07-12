package com.coderscampus.Week18.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity // This represents an entity in the database
@Table(name = "users") // because user is a reserved table in the database we have to use this name and
						// annotation type
public class User {

	private Long userId;
	private String username;
	private String password;
	private String name;
	private List<Account> accounts = new ArrayList<>();
	private Address address; // this is a relationship between user and address a One to One relationship

	@Id // this makes the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this automatically generates the primary key
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

	@ManyToMany
	@JoinTable(name = "user_account", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@OneToOne(mappedBy = "user")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", accounts=" + accounts + ", address=" + address + "]";
	}

}
