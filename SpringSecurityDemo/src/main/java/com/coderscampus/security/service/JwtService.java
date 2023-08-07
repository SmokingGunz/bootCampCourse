package com.coderscampus.security.service;

import java.security.Key;

import java.util.*;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	/**
	 * What we need to be able to do with JWTs in this class 
	 * 0. Create JWT signing key 
	 * 1. create / generate the JWT 
	 * 2. Extract claims (ie get stuff from the payload) 
	 * 3. Verify that the JWT is valid 
	 * 4. Sign the JWT
	 */

	@Value("${jwt.signingKey}")
	private String jwtSigningKey;
	
	@Value("${jwt.expirationTimeInMillis}")
    private Long expirationTimeInMillis;
	
	public Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				   .setSigningKey(getSigningKey())
				   .build()
				   .parseClaimsJws(token).getBody();
	}
	
	public String getSubject(String token) {
		String subject = extractClaims(token, Claims::getSubject);
		return subject;
	}
	
	public Boolean isTokenValid(String token, UserDetails user) {

		String subject = getSubject(token);
		
		Date expirationDate = extractClaims(token, Claims::getExpiration);
		
		return user.getUsername().equalsIgnoreCase(subject) && new Date().before(expirationDate);
	}
	
	public <T> T extractClaims(String token, Function<Claims, T> claimsExtract) {
		
		Claims allClaims = extractAllClaims(token);
		
        return claimsExtract.apply(allClaims);
	}

	public String generateToken(Map<String, Object> extraClaims, UserDetails user) {

		String jwt = Jwts.builder()
		.setClaims(extraClaims)
		.setSubject(user.getUsername())
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMillis))
		.setHeaderParam("typ", Header.JWT_TYPE)
		.signWith(getSigningKey(), SignatureAlgorithm.HS256)
		.compact();
		return jwt;

	}
	
	private Key getSigningKey() {
        byte[] encodedKey = Decoders.BASE64.decode(jwtSigningKey);
        SecretKey hmacShaKeyFor = Keys.hmacShaKeyFor(encodedKey);
        return hmacShaKeyFor;
    }

	public void setJwtSigningKey(String jwtSigningKey) {
		if (this.jwtSigningKey == null)
			this.jwtSigningKey = jwtSigningKey;
	}

	public void setExpirationTimeInMillis(Long expirationTimeInMillis) {
		if (this.expirationTimeInMillis == null)
		this.expirationTimeInMillis = expirationTimeInMillis;
	}
	
}
