package com.example.drycleaner.dto;

import com.example.drycleaner.dto.user.response.UserResponseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TokenResponse {
    String accessToken;
    UserResponseDto user;
}
