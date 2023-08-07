package com.coderscampus.security.security;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// Requests:
		// Headers -> key/value (Authentication -< Bearer xxx-yyy-zzzz)
        // Body -> key/value
		
		String auth = request.getHeader("Authorization");
		
        if (auth!= null && auth.startsWith("Bearer ")) {
            auth = auth.substring(7);
        }
        
        if (auth!= null && auth.length() > 0) {
        	String username = Jwts.parser().setSigningKey(SecurityConstants.SECRET.getBytes()).parseClaimsJws(auth).getBody().getSubject();
            request.setAttribute("username", username);
            filterChain.doFilter(request, response);
         
        }
		
	}

}
