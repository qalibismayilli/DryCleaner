package com.reserveall.drycleaner.dto.request

import com.reserveall.drycleaner.dto.ServiceDto


data class DryCleanerRequestDto(
    val name: String,
    val location: String,
    val description: String?,
    val services: List<ServiceDto>

)
