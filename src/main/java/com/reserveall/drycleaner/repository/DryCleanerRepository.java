package com.reserveall.drycleaner.repository;

import com.reserveall.drycleaner.dto.response.ServiceResponseDto;
import com.reserveall.drycleaner.model.DryCleaner;
import com.reserveall.drycleaner.model.ServiceName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface DryCleanerRepository extends JpaRepository<DryCleaner, String> {


    Optional<DryCleaner> findDryCleanerByUser_Id(String userId);

    @Query("update DryCleaner dc set dc.dryCleanerName = :name, dc.location = :location," +
            " dc.description = :description where dc.id = :dryCleanerId")
    @Modifying
    @Transactional
    Optional<DryCleaner> updateDryCleaner(String name, String location, String description, String dryCleanerId);

    Optional<List<DryCleaner>> findDryCleanersByDryCleanerName(String name);

    @Query("select dc.id, dc.createdDate, dc.updatedDate, dc.dryCleanerName," +
            "dc.location, dc.description, dc.services, dc.images, dc.user from DryCleaner dc where ")
    Optional<List<DryCleaner>>  findDryCleanersByService(String serviceName);

}
