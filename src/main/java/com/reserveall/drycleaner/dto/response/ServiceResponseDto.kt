package com.reserveall.drycleaner.dto.response

import com.reserveall.drycleaner.model.ServiceName

data class ServiceResponseDto(

    val id: String?,

    val serviceName: ServiceName?,

    val price: Int?,

    val discountRate: Int?
)
