package com.example.drycleaner.dto.service.response

data class ServiceResponseDto(

    val id: String,

    val serviceName: String?,

    val price: Int?,

    val discountRate: Int?
)