package com.reserveall.drycleaner.dto.service.request

import com.reserveall.drycleaner.model.ServiceName

data class ServiceRequestDto(
    val id: String?,

    val serviceName: ServiceName?,

    val price: Int?,
)