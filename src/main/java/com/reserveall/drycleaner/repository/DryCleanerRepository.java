package com.reserveall.drycleaner.repository;

import com.reserveall.drycleaner.model.DryCleaner;
import com.reserveall.drycleaner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DryCleanerRepository extends JpaRepository<DryCleaner, String> {

    Optional<DryCleaner> findDryCleanerByUser(User user);


    Optional<DryCleaner> findDryCleanerByUser_Id(String userId);

}
