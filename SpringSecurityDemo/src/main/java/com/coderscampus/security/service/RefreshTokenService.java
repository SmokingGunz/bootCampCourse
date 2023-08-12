package com.coderscampus.security.service;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.coderscampus.security.domain.RefreshToken;
import com.coderscampus.security.domain.User;

@Service
public class RefreshTokenService {
	
	private UserService userService;
	
	@Value("${jwt.refreshTokenExpirationInMillis")
	private Long refreshTokenExpirationInMillis;
	
	public RefreshTokenService(UserService userService) {
        this.userService = userService;
    }

	public RefreshToken generateRefreshToken(Long userId) {
		
		Optional<User> userOpt = userService.findById(userId);

		if (userOpt.isPresent()) {
			
			return new RefreshToken(null, userOpt.get(), UUID.randomUUID().toString(), new Date(System.currentTimeMillis() + refreshTokenExpirationInMillis));
		}
		return null;
	}
}
