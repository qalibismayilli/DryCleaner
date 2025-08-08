package com.reserveall.drycleaner.dto.dry_cleaner.request

data class DryCleanerUpdateRequestDto(
    val name: String,
    val location: String,
    val description: String?
)
