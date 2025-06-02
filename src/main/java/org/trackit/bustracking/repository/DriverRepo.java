package org.trackit.bustracking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.trackit.bustracking.model.Driver;

import java.util.Optional;
@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer> {
    Optional<Driver> findByUsername(String username);
}
