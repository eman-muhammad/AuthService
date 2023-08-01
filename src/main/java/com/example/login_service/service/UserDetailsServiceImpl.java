package com.example.login_service.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.login_service.dto.UserDetailsImpl;
import com.example.login_service.model.User;
import com.example.login_service.repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("user details service called");
       User user =  userRepo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("email not found"));
        return new UserDetailsImpl(user);
    }
    
}
