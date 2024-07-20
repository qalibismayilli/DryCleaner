package com.reserveall.drycleaner.dto.request

data class DryCleanerUpdateRequestDto(
    val name: String,
    val location: String,
    val description: String?
)
