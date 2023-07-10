package com.coderscampus.Week18.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

	private Long accountId;
	private String accountName;
	private List<Transaction> transactions = new ArrayList<>();   // One to Many mapping in the database relationship between accounts and transactions
	private List<User> users = new ArrayList<>();   // Many to Many mapping in the database relationship between accounts and users

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Column(length = 100)
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@OneToMany(mappedBy = "account")  // One to Many mapping in the database relationship between accounts and transactions
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	@OneToMany(mappedBy = "accounts")  // Many to Many mapping in the database relationship between accounts and users
    public List<User> getUsers() {
        return users;
    }
	
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
