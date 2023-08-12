package com.coderscampus.security.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public record RefreshToken(
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		Long id, 
		@OneToOne
		@JoinColumn(name="user_id", referencedColumnName="id")
		User user, 
		String refreshToken, 
		Date expirationDate) {

}
