package com.example.drycleaner.dto.user.response;

import com.example.drycleaner.model.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserResponseDto {
    String userId;
    String username;
    Role role;
    String email;
}
