package com.reserveall.drycleaner.dto

import com.reserveall.drycleaner.model.ServiceName

data class ServiceDto(

    val id: String?,

    val serviceName: ServiceName?,

    val price: Integer?,
)
