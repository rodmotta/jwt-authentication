package com.github.rodmotta.jwtauthentication.services.impl;

import com.github.rodmotta.jwtauthentication.models.User;
import com.github.rodmotta.jwtauthentication.services.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${auth.jwt.expiration}")
    private String expiration;

    @Value("${auth.jwt.secretKey}")
    private String secretKey;

    @Override
    public String generateToken(Authentication authentication) {
        User loggedUser = (User) authentication.getPrincipal();

        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Jwt authentication with spring security")
                .setSubject(loggedUser.getId().toString())
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    @Override
    public boolean isValid(String token) {
        try{
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Long getUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }
}
