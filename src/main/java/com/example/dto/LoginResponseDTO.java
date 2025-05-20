package com.example.dto;
//class added by grok do not fully trust
//returns JWT and expiration time after login
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class LoginResponseDTO {
private String token;
private long expiresIn;

public LoginResponseDTO(String token, long expiresIn)
{
    this.token=token;
    this.expiresIn=expiresIn;
}
}