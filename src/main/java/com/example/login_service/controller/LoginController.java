package com.example.login_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login_service.dto.AuthRequest;
import com.example.login_service.dto.AuthResponse;
import com.example.login_service.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @PostMapping("")
    ResponseEntity<AuthResponse> login (@RequestBody AuthRequest authRequest){
    log.info("auth request");
        AuthResponse authResponse = loginService.login(authRequest);
        return ResponseEntity.ok(authResponse);
    }



    
}
