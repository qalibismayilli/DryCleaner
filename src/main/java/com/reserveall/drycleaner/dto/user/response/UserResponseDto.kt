package com.reserveall.drycleaner.dto.user.response

import com.reserveall.drycleaner.model.Role

data class UserResponseDto(
    val id: String?,
    val username: String?,
    val role: Role?,
    val email: String?
)