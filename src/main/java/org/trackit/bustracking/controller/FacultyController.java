package org.trackit.bustracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trackit.bustracking.ServiceImplementation.FacultyService;
import org.trackit.bustracking.model.Faculty;
import org.trackit.bustracking.model.UserCredentials;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins = "*")
public class FacultyController {

    FacultyService facultyService;
    @Autowired
    public void setFacultyService(FacultyService facultyService) {this.facultyService = facultyService;}
    @PostMapping("/register")
    public Faculty saveFaculty(@RequestBody Faculty faculty) {
        return facultyService.saveFaculty(faculty);
    }
    @PostMapping("/login")
    public boolean login(@RequestBody UserCredentials userCredentials) {
        return  facultyService.checkPassword(userCredentials.getPassword(),userCredentials.getUsername());

    }
    @GetMapping
    public List<Faculty> getAllFaculty() {
        return facultyService.findAllFaculty();
    }
    @GetMapping("/{id}")
    public Optional<Faculty> getFaculty(@PathVariable int id) {
        return facultyService.findFacultyById(id);
    }
    @PutMapping()
    public Optional<Faculty> updateFaculty( @RequestBody Faculty faculty) {
        return Optional.ofNullable(facultyService.updateFaculty(faculty));
    }
    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable int id) {
     Optional<Faculty> f=   facultyService.findFacultyById(id);
        facultyService.deleteFaculty(f.orElse(null));
    }

}
