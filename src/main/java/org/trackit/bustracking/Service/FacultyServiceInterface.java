package org.trackit.bustracking.Service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.trackit.bustracking.model.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyServiceInterface {
    Faculty saveFaculty(Faculty faculty);
   Optional<Faculty> findFacultyById(long id);
   Optional<Faculty> findFacultyByUsername(String username);
   List<Faculty> findAllFaculty();
   Faculty updateFaculty(Faculty faculty);
   void deleteFaculty(Faculty faculty);
   boolean checkPassword(String password,String username);
}
