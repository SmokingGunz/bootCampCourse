package com.coderscampus.security.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.coderscampus.security.service.JwtService;
import com.coderscampus.security.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private JwtService jwtService;
	private UserService userService;

	public JwtAuthenticationFilter(JwtService jwtService, UserService userService) {
		super();
		this.jwtService = jwtService;
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Requests:
		// Headers -> key/value (Authentication -< Bearer xxx-yyy-zzzz)
		// Body -> key/value

		String authHeader = request.getHeader("Authorization");

		if (StringUtils.hasText(authHeader)) {
			String token = authHeader.substring(7);

			String subject = jwtService.getSubject(token);

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (StringUtils.hasText(subject) && authentication == null) {

				UserDetails userDetails = userService.loadUserByUsername(subject);

				if (jwtService.isTokenValid(token, userDetails)) {
					SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,
							userDetails.getPassword());

					securityContext.setAuthentication(auth);

					SecurityContextHolder.setContext(securityContext);
				}
			}

		}
		filterChain.doFilter(request, response);

	}

}
