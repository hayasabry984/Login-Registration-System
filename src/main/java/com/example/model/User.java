package com.example.model;

//represents users in the database
//stores user data and email verification details (code, expiration, enabled status) to support the email verification feature.
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Collection;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

@Entity //defines JPA entity that maps to the users table in the database
@Table(name="users")
@Getter
@Setter

//Implementing `UserDetails` allows Spring Security to use the entity for authentication
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO) //auto generates a unique ID for each user
    private Long id;

    @Column(unique=true, nullable=false)
    private String username;

    @Column(unique=true, nullable=false)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(name="verification_code")
    private String verificationCode;

    @Column(name="verification_expiration")
    private LocalDateTime verificationExpiresAt;

    private boolean enabled;

    //constructor for creating and verifying users
    public User(String username, String email, String password)
    {
        this.username=username;
        this.email=email;
        this.password=password;
    }

    //default constructor
    public User()
    {}

    //method required by Spring Security that gets the roles or permissions (authorities) granted to the user
    //Return an empty list because we don't use roles.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return enabled;
    }
}
