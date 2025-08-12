package com.example.drycleaner.service;

import com.example.drycleaner.dto.LoginRequest;
import com.example.drycleaner.dto.TokenResponse;
import com.example.drycleaner.dto.user.response.UserResponseDto;
import com.example.drycleaner.service.user.UserService;
import com.example.drycleaner.util.TokenGenerator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserService userService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserService userService, TokenGenerator tokenGenerator,
                       AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponse login(LoginRequest request){
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

            return new TokenResponse(tokenGenerator.generateToken(auth),
                    userService.convertToResponse(userService.findUserByUsername(request.getUsername())));
        }catch (Exception ex){
            throw new BadCredentialsException(ex.getMessage());
        }
    }

    public UserResponseDto getLoggedInUser(){
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .getUsername();
        return userService.convertToResponse(userService.findUserByUsername(username));
    }
}