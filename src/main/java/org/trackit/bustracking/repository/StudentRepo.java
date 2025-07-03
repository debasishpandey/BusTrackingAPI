package org.trackit.bustracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.trackit.bustracking.model.Bus;
import org.trackit.bustracking.model.Student;

import java.util.Optional;
@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
    Optional<Student> findByUsername(String username);
    @Query("SELECT s.assignedBus FROM Student s WHERE s.registrationNo = :regNo")
    Bus findBusByStudentRegistrationNo(@Param("regNo") String registrationNo);
    Optional<Student> findByEmail(String email);

}
