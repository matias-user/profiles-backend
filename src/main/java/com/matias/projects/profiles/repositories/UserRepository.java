package com.matias.projects.profiles.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matias.projects.profiles.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhoneNumber(int phoneNumber);
    List<User> findByRolesName(String role);
}
