package com.reserveall.drycleaner.dto.response

import com.reserveall.drycleaner.dto.ServiceDto

data class DryCleanerResponseDto(
    val id: String?,
    val name: String?,
    val location: String?,
    val description: String?,
    val services: List<ServiceDto>?,
    val imageUrls: List<String>?,
    val user: UserResponseDto?
)
