package com.coderscampus.security.service;

import java.security.Key;
import java.sql.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtService {

	/**
	 * What we need to be able to do with JWTs in this class 0. Create JWT signing
	 * key 1. create / generate the JWT 2. Extract claims (ie get stuff from the
	 * payload) 3. Verify that the JWT is valid 4. Sign the JWT
	 */

	@Value("${jwt.signingKey}")
	private String jwtSigningKey;
	
	@Value("${jwt.expirationTimeInMillis}")
    private long expirationTimeInMillis;

	public String generateToken(Map<String, Object> extraClaims, UserDetails user) {

		String jwt = Jwts.builder()
		.setClaims(extraClaims)
		.setSubject(user.getUsername())
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMillis))
		.signWith(getSigningKey(), SignatureAlgorithm.HS256)
		.compact();
		return jwt;

	}
	
	private Key getSigningKey() {
        byte[] encodedKey = Decoders.BASE64.decode(jwtSigningKey);
        SecretKey hmacShaKeyFor = Keys.hmacShaKeyFor(encodedKey);
        return hmacShaKeyFor;
    }
}
