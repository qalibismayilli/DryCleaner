package com.example.drycleaner.service.user;

import com.example.drycleaner.dto.user.request.UserRequestDto;
import com.example.drycleaner.dto.user.request.UserUpdateRequestDto;
import com.example.drycleaner.dto.user.response.UserResponseDto;
import com.example.drycleaner.model.User;
import com.example.drycleaner.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getOriginalUserById(String userId){
        return userRepository.findById(userId).orElseThrow();
    }

    public UserResponseDto create(UserRequestDto dto){
        return convertToResponse(userRepository.save(convertToUser(dto)));
    }

    public UserResponseDto update(UserUpdateRequestDto dto){
        User existingUser = getOriginalUserById(dto.getUserId());

        if(dto.getPassword() != null){
            existingUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        existingUser.setUsername(dto.getUsername());
        existingUser.setEmail(dto.getEmail());
        existingUser.setRole(dto.getRole());
        return convertToResponse(userRepository.save(existingUser));
    }

    public List<UserResponseDto> getAllUsers(){
        return userRepository.findAll().stream().map(this::convertToResponse).toList();
    }

    public UserResponseDto getUserById(String userId){
        return convertToResponse(userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found!")));
    }

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("user not found by given username!"));
    }

    public User convertToUser(UserRequestDto dto){
        return User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole()).build();
    }

    public User convertToUser(UserUpdateRequestDto dto){
        return User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole()).build();
    }


    public UserResponseDto convertToResponse(User user){
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole()).build();
    }

}