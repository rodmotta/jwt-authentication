package com.github.rodmotta.jwtauthentication.controllers;

import com.github.rodmotta.jwtauthentication.dto.TokenDto;
import com.github.rodmotta.jwtauthentication.dto.form.SignInForm;
import com.github.rodmotta.jwtauthentication.dto.form.SignUpForm;
import com.github.rodmotta.jwtauthentication.services.TokenService;
import com.github.rodmotta.jwtauthentication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager; // SecurtyConfig bean

    @PostMapping("/sign-in")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInForm signInForm){
        UsernamePasswordAuthenticationToken loginData = new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword());

        try {
            Authentication authentication = authenticationManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(TokenDto.builder().type("Bearer ").token(token).build());
        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody SignUpForm signUpForm){
        userService.save(signUpForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
