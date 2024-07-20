package com.reserveall.drycleaner.repository;

import com.reserveall.drycleaner.model.Service;
import com.reserveall.drycleaner.model.ServiceName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, String> {

    Optional<List<Service>> findServicesByServiceName(ServiceName serviceName);
}
