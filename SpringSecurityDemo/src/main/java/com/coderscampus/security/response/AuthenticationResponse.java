package com.coderscampus.security.response;

public record AuthenticationResponse(String username, String accessToken, String refreshToken) {

}
