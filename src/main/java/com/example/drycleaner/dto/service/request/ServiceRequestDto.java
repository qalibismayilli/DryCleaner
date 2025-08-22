package com.example.drycleaner.dto.service.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceRequestDto {
    String serviceId;
    String serviceName;
    Double price;
}
