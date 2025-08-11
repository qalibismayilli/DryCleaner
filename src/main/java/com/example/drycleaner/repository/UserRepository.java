package com.example.drycleaner.repository;

import com.example.drycleaner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query
    Optional<User> findUserByUsername(String username);
}
