package com.github.rodmotta.jwtauthentication.services;

import com.github.rodmotta.jwtauthentication.dto.form.SignUpForm;
import com.github.rodmotta.jwtauthentication.models.User;

public interface UserService {
    void save(SignUpForm signUpForm);
    User findById(Long userId);
    User findByUsername(String username);
}
