package org.trackit.bustracking.ServiceImplementation;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.trackit.bustracking.Service.FacultyServiceInterface;
import org.trackit.bustracking.model.Faculty;
import org.trackit.bustracking.repository.FacultyRepo;
import org.trackit.bustracking.utill.PasswordEncoder;

import java.util.List;
import java.util.Optional;
@Service
public class FacultyService implements FacultyServiceInterface {


    @PostConstruct
    public void init() {
        System.out.println("✅ FacultyService loaded into Spring context");
    }

    FacultyRepo facultyRepo;

//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    public void setFacultyRepo(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }



    @Override
    public Faculty saveFaculty(Faculty faculty) {



        return facultyRepo.save(faculty);
    }

    @Override
    public Optional<Faculty> findFacultyById(long id) {
        return facultyRepo.findById(id);
    }

    @Override
    public Optional<Faculty> findFacultyByUsername(String username) {
        return facultyRepo.findFacultyByUsername(username);
    }

    @Override
    public List<Faculty> findAllFaculty() {
        return facultyRepo.findAll();
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepo.save(faculty);
    }

    @Override
    public void deleteFaculty(Faculty faculty) {
        facultyRepo.delete(faculty);
    }

    @Override
    public boolean checkPassword(String password,String username) {
       Optional<Faculty> f= facultyRepo.findFacultyByUsername(username);
       if(f.isPresent()){
            return PasswordEncoder.checkPassword(password,f.get().getPassword());
       }
        System.out.println(username);
        return false;
    }


}
