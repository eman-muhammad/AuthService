package com.example.login_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModel <T> {
   
    private T data ;
}
