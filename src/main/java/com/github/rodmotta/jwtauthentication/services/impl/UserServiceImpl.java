package com.github.rodmotta.jwtauthentication.services.impl;

import com.github.rodmotta.jwtauthentication.dto.form.SignUpForm;
import com.github.rodmotta.jwtauthentication.enums.RoleEnum;
import com.github.rodmotta.jwtauthentication.models.Role;
import com.github.rodmotta.jwtauthentication.models.User;
import com.github.rodmotta.jwtauthentication.repository.RoleRepository;
import com.github.rodmotta.jwtauthentication.repository.UserRepository;
import com.github.rodmotta.jwtauthentication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public void save(SignUpForm signUpForm) {
        Role roleUser = roleRepository.findById(RoleEnum.USER.getId).get();
        Role roleAdmin = roleRepository.findById(RoleEnum.ADMIN.getId).get();

        User user = User.builder()
                .username(signUpForm.getUsername())
                .password(new BCryptPasswordEncoder().encode(signUpForm.getPassword()))
                .roles(signUpForm.isAdmin() ? Set.of(roleUser, roleAdmin) : Set.of(roleUser))
                .build();

        userRepository.save(user);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException());
    }
}
