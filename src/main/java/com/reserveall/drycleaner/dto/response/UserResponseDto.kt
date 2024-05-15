package com.reserveall.drycleaner.dto.response

import com.reserveall.drycleaner.model.Role

data class UserResponseDto(
    val id: String?,
    val username: String?,
    val role: Role?,
    val email: String?
)
