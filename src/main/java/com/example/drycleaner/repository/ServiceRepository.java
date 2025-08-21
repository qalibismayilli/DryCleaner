package com.example.drycleaner.repository;

import com.example.drycleaner.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, String> {

    Optional<List<Service>> findServicesByServiceName(String serviceName);
}
