package com.example.drycleaner.dto.dry_cleaner.request;

import com.example.drycleaner.dto.service.request.ServiceRequestDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DryCleanerRequestDto {
    String name;
    String location;
    String description;
    List<ServiceRequestDto> services;
}
