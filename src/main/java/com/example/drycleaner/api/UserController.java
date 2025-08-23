package com.example.drycleaner.api;


import com.example.drycleaner.dto.user.request.UserRequestDto;
import com.example.drycleaner.dto.user.request.UserUpdateRequestDto;
import com.example.drycleaner.dto.user.response.UserResponseDto;
import com.example.drycleaner.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto request){
        return ResponseEntity.ok(userService.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserUpdateRequestDto request){
        return ResponseEntity.ok(userService.update(request));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") UUID userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }


}
