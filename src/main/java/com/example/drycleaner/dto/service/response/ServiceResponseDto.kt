package com.example.drycleaner.dto.service.response

import com.example.drycleaner.model.ServiceName

data class ServiceResponseDto(

    val id: String?,

    val serviceName: ServiceName?,

    val price: Int?,

    val discountRate: Int?
)