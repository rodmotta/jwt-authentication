package com.github.rodmotta.jwtauthentication.repository;

import com.github.rodmotta.jwtauthentication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
