package org.trackit.bustracking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackit.bustracking.ServiceImplementation.StudentService;
import org.trackit.bustracking.model.Bus;
import org.trackit.bustracking.model.Student;
import org.trackit.bustracking.model.UserCredentials;
import org.trackit.bustracking.utill.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserCredentials userCredentials) {
       return studentService.checkPassword(userCredentials.getPassword(), userCredentials.getUsername());
    }
    @PostMapping("register")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    @GetMapping("all")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable String id) {
        return studentService.getStudentById(id);
    }
    @GetMapping("/user/{username}")
    public Optional<Student> getStudentByUsername(@PathVariable String username) {
        return studentService.getStudentByUsername(username);
    }

    @GetMapping("byregdno/{registrationNumber}")
    public Optional<Student> getStudentByRegistrationNumber(@PathVariable String registrationNumber) {
        return studentService.getStudentByRegistrationNumber(registrationNumber);
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("assign-bus/{registrationNo}")
    public Bus getBusesByStudent(@PathVariable String registrationNo) {
        Bus bus=studentService.getAssignedBus(registrationNo);
        return bus;
    }

    @PutMapping("/update-status/{registrationNo}")
    public Student updateStudentStatus(@PathVariable String registrationNo) {
        Optional<Student> student=studentService.getStudentById(registrationNo);
        if(student.isPresent()) {
            student.get().setIsComingToday(!student.get().getIsComingToday());
            studentService.updateStudent(student.get());
            return student.get();
        }
        return null;
    }

    @PostMapping("reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody UserCredentials userCredentials) {
        Student student=studentService.getStudentByEmail(userCredentials.getUsername());
        if(student!=null) {
            student.setPassword(PasswordEncoder.encode(userCredentials.getPassword()));
            studentService.updateStudent(student);
            return ResponseEntity.ok("Password reset");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
    }
    @GetMapping("email/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

}
