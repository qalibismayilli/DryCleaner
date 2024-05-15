package com.reserveall.drycleaner.service;

import com.reserveall.drycleaner.model.User;
import com.reserveall.drycleaner.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    protected User getOriginalUserById(String userId){
        return userRepository.findById(userId).orElseThrow();
    }
}
