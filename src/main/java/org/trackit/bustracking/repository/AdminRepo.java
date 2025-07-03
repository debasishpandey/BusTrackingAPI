package org.trackit.bustracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackit.bustracking.model.Admin;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByUsername(String username);


}
