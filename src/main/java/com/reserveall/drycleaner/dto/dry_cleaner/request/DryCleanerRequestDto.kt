package com.reserveall.drycleaner.dto.dry_cleaner.request

import com.reserveall.drycleaner.dto.service.request.ServiceRequestDto


data class DryCleanerRequestDto(
    val name: String,
    val location: String,
    val description: String?,
    val services: List<ServiceRequestDto>
)
