package com.reserveall.drycleaner.repository;

import com.reserveall.drycleaner.model.DryCleaner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DryCleanerRepository extends JpaRepository<DryCleaner, String> {
}
