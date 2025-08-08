package com.reserveall.drycleaner.dto.dry_cleaner.response

import com.reserveall.drycleaner.dto.service.response.ServiceResponseDto

data class DryCleanerResponseDto(
    val id: String?,
    val name: String?,
    val location: String?,
    val description: String?,
    val services: List<ServiceResponseDto>?,
    val imageUrls: List<String>?,
    val userId: String?
)