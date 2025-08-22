package com.example.drycleaner.dto.dry_cleaner.response;

import com.example.drycleaner.dto.service.response.ServiceResponseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class DryCleanerResponseDto {
    UUID dryCleanerId;
    String name;
    String location;
    String description;
    List<ServiceResponseDto> services;
    List<String> imageUrl;
    UUID userId;
}
