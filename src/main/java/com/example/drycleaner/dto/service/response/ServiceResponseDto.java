package com.example.drycleaner.dto.service.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ServiceResponseDto {
    UUID serviceId;
    String serviceName;
    Double price;
    Double discount;
}
