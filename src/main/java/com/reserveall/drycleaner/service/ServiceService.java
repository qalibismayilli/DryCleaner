package com.reserveall.drycleaner.service;

import com.reserveall.drycleaner.model.ServiceName;
import com.reserveall.drycleaner.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    protected List<com.reserveall.drycleaner.model.Service> findServicesByName(ServiceName serviceName) {
         return serviceRepository.findServicesByServiceName(serviceName)
                .orElseThrow();
    }


}
