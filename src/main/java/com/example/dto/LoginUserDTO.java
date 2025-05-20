package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//holds the login credentials (email, password)
public class LoginUserDTO {
    private String email;
    private String password;
}