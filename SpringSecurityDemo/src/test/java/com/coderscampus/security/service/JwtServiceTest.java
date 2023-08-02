package com.coderscampus.security.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coderscampus.security.domain.User;

@TestInstance(Lifecycle.PER_CLASS)
//@TestPropertySource("classpath:application.properties")
//@SpringBootTest
class JwtServiceTest {
	
	// Create a system under test
//	@Autowired
	private static JwtService sut;
	
	@BeforeAll
	static void init() {
	    sut = new JwtService();
	    sut.setExpirationTimeInMillis(3000000L);
	    sut.setJwtSigningKey("55C22FBE66951540E89114AC314D747257AEA74B17320E0F254859AAA794F587");
//	    ReflectionTestUtils.setField(sut, "jwtSigningKey", "YOUR_SIGNING_KEY_HERE"); // replace with your actual signing key
//	    ReflectionTestUtils.setField(sut, "expirationTimeInMillis", 360000); // replace with your actual expiration time
	}

	@Test
	void testGenerateToken() {
		
		// arrange, act, assert
		
		//Act
		Map<String, Object> extraClaims = new HashMap<>();
		User user = new User("trevor@coderscampus.com", "abc123");
		
		// Arrange
		String jwt = sut.generateToken(extraClaims, user);
		
		
		//Assert
		System.out.println(jwt);
		
	}

}
