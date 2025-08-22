package com.example.drycleaner.dto.dry_cleaner.request;

import com.example.drycleaner.dto.service.request.ServiceRequestDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DryCleanerUpdateRequestDto {
    String name;
    String location;
    String description;
}
