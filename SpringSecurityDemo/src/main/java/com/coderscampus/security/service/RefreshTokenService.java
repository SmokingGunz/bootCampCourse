package com.coderscampus.security.service;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.coderscampus.security.domain.RefreshToken;
import com.coderscampus.security.domain.User;
import com.coderscampus.security.repository.RefreshTokenRepository;

@Service
public class RefreshTokenService {

	private UserService userService;
	private RefreshTokenRepository refreshTokenRepo;

	@Value("${jwt.refreshTokenExpirationTimeInMillis}")
	private Long refreshTokenExpirationInMillis;

	public RefreshTokenService(UserService userService, RefreshTokenRepository refreshTokenRepo) {
		super();
		this.userService = userService;
		this.refreshTokenRepo = refreshTokenRepo;
	}

	public RefreshToken generateRefreshToken(Long userId) {

		Optional<User> userOpt = userService.findById(userId);

		if (userOpt.isPresent()) {

			RefreshToken refreshToken = new RefreshToken(userOpt.get(), UUID.randomUUID().toString(),
					new Date(System.currentTimeMillis() + refreshTokenExpirationInMillis));

			refreshTokenRepo.save(refreshToken);

			return refreshToken;

		}
		return null;
	}
}
