package com.example.drycleaner.dto.service.request

import com.example.drycleaner.model.ServiceName

data class ServiceRequestDto(
    val id: String?,

    val serviceName: ServiceName?,

    val price: Int?,
)