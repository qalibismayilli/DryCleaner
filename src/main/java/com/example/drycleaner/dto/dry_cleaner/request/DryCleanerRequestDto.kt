package com.example.drycleaner.dto.dry_cleaner.request

import com.example.drycleaner.dto.service.request.ServiceRequestDto


data class DryCleanerRequestDto(
    val name: String,
    val location: String,
    val description: String?,
    val services: List<ServiceRequestDto>
)
