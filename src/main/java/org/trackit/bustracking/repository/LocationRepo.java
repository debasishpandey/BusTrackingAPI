package org.trackit.bustracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackit.bustracking.model.Location;
@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {

}
