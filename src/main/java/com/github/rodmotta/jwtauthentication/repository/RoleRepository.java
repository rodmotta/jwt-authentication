package com.github.rodmotta.jwtauthentication.repository;

import com.github.rodmotta.jwtauthentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
