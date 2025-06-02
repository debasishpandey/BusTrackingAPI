package org.trackit.bustracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackit.bustracking.model.Faculty;

import java.util.Optional;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long> {
    Optional<Faculty> findFacultyByUsername(String username);

}
