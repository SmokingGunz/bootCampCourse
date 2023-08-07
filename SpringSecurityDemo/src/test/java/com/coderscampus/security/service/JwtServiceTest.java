package com.coderscampus.security.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.coderscampus.security.domain.User;

import io.jsonwebtoken.Claims;

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
	@DisplayName("Should generate token")
	void testGenerateToken() {

		// arrange, act, assert

		// Arrange
		Map<String, Object> extraClaims = new HashMap<>();
		User user = new User("trevor@coderscampus.com", "abc123");

		// Act
		String jwt = sut.generateToken(extraClaims, user);

//		jwt = "test";

		// Assert
		System.out.println(jwt);

		assertTrue(jwt.startsWith("ey"));

	}
	
	@Test
	@DisplayName("Should extract all claims from token")
    void testExtractAllClaims() {
		
		// arrange, act, assert
		
		// Arrange
        Map<String, Object> extraClaims = new HashMap<>();
        User user = new User("trevor@coderscampus.com", "abc123");
        String jwt = sut.generateToken(extraClaims, user);
        
        // Act
        Claims allClaims = sut.extractAllClaims(jwt);
        
        System.out.println(allClaims);
        
        // Assert
        
        assertEquals("trevor@coderscampus.com", allClaims.getSubject());
        assertEquals(allClaims.size(), 3);
        
//        assertTrue(allClaims.getSubject().equals("trevor@coderscampus.com"));
        
	}
	
	@Test
	@DisplayName("Should extract valid subject from claims")
    void testExtractSubject() {
		
		// arrange, act, assert
		
		
		// Arrange
        Map<String, Object> extraClaims = new HashMap<>();
        User user = new User("trevor@coderscampus.com", "abc123");
        String jwt = sut.generateToken(extraClaims, user);
        
        // Act
        
        String subject = sut.getSubject(jwt);
        
        // Assert
        
        assertEquals("trevor@coderscampus.com", subject);
		
		
	}
	
	@Test
	@DisplayName("Should return a valid token")
    void testValidToken() {
		
		// arrange, act, assert
		
		
		// Arrange
        Map<String, Object> extraClaims = new HashMap<>();
        User user = new User("trevor@coderscampus.com", "abc123");
        String jwt = sut.generateToken(extraClaims, user);
        
        // Act
        
        Boolean tokenValid = sut.isTokenValid(jwt, user);
        // Assert
        
        assertTrue(tokenValid);
		
	}
	
	@Test
	@DisplayName("Should return a invalid token")
    void testInvalidToken() {
		
		// arrange, act, assert
		
		
		// Arrange
        Map<String, Object> extraClaims = new HashMap<>();
        User validUser = new User("trevor@coderscampus.com", "abc123");
        User invalidUser = new User("trevor.page@coderscampus.com", "abc123");

        String jwt = sut.generateToken(extraClaims, validUser);
        
        // Act
        
        Boolean tokenValid = sut.isTokenValid(jwt, invalidUser);
        // Assert
        
        assertFalse(tokenValid);
		
	}
	

}
