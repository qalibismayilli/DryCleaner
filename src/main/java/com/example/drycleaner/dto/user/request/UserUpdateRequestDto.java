package com.example.drycleaner.dto.user.request;

import com.example.drycleaner.model.DryCleaner;
import com.example.drycleaner.model.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequestDto {
    UUID userId;
    String username;
    String password;
    Role role;
    String email;
}
