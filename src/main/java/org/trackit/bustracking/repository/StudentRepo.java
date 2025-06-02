package org.trackit.bustracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackit.bustracking.model.Student;

import java.util.Optional;
@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
    Optional<Student> findByUsername(String username);
}
