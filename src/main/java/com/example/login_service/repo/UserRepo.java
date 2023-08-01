package com.example.login_service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login_service.model.User;

public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    
}
