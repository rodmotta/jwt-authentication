package com.github.rodmotta.jwtauthentication.services;

import org.springframework.security.core.Authentication;

public interface TokenService {
    String generateToken(Authentication authentication);
    boolean isValid(String token);
    Long getUserId(String token);
}
