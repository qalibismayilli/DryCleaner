package com.example.drycleaner.repository;

import com.example.drycleaner.model.DryCleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DryCleanerRepository extends JpaRepository<DryCleaner, UUID> {


    Optional<DryCleaner> findDryCleanerByDryCleanerId(UUID dryCleanerId);

    @Query("update DryCleaner dc set dc.dryCleanerName = :name, dc.location = :location," +
            " dc.description = :description where dc.dryCleanerId = :dryCleanerId")
    @Modifying
    @Transactional
    Optional<DryCleaner> updateDryCleaner(String name, String location, String description, UUID dryCleanerId);

    Optional<List<DryCleaner>> findDryCleanersByDryCleanerName(String name);


    //TODO:
    @Query("select dc.dryCleanerId, dc.createdDate, dc.updatedDate, dc.dryCleanerName," +
            "dc.location, dc.description, dc.services, dc.images, dc.user from DryCleaner dc where 1=1")
    Optional<List<DryCleaner>>  findDryCleanersByService(String serviceName);

}
