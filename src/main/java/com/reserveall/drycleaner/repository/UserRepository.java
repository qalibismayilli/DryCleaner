package com.reserveall.drycleaner.repository;

import com.reserveall.drycleaner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
