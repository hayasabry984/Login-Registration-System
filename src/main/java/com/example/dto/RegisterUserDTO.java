package com.example.dto;
//holds registration data (username, email, password)

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegisterUserDTO {
    private String username;
    private String password;
    private String email;
}