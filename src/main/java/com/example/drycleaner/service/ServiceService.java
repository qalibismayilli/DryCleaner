package com.example.drycleaner.service;

import com.example.drycleaner.model.ServiceName;
import com.example.drycleaner.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    protected List<com.example.drycleaner.model.Service> findServicesByName(ServiceName serviceName) {
         return serviceRepository.findServicesByServiceName(serviceName)
                .orElseThrow();
    }


}
