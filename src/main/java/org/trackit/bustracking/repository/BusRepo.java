package org.trackit.bustracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackit.bustracking.model.Bus;

import java.util.Optional;
@Repository
public interface BusRepo extends JpaRepository<Bus, Long> {

}
