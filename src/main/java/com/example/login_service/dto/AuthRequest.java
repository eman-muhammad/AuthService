package com.example.login_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    
    private String email;
    private String password;
}
