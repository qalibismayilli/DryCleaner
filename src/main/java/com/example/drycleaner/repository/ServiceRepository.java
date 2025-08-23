package com.example.drycleaner.repository;

import com.example.drycleaner.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {

    Optional<List<Service>> findServicesByServiceName(String serviceName);
}
