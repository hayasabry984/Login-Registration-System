package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//holds verification data (email,code)
public class VerifyingUserDTO {
    private String email;
    private String verificationCode;
}