package com.example.login_service.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.login_service.dto.AuthRequest;
import com.example.login_service.dto.AuthResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final AuthenticationManager authenticationManager;

    private final UserDetailsServiceImpl userDetailsService;

    private final JwtService jwtService;

    public  AuthResponse login (AuthRequest authRequest){
        log.info("auth service called");
        String email = authRequest.getEmail();
        String password = authRequest.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        
        final UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        String token = jwtService.generateToken(userDetails);
        return new AuthResponse(token);
    }
    
}
