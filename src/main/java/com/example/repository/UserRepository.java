package com.example.repository;
//repository interface handles database operations on the user entity
//crud repository provides basic CRUD operations (create, read, update, delete)
// spring data JPA generates database quires automatically simplifying crud operations
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository; original
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> //chatgpt suggestion
//public interface UserRepository extends CrudRepository<User,Long> //original
{
//Optional handles cases when user may not exist
    Optional<User> findByEmail(String email); //retrieves user by email
    Optional<User> findByVerificationCode(String verificationCode); //support email verification code
}