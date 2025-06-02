package org.trackit.bustracking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trackit.bustracking.ServiceImplementation.StudentService;
import org.trackit.bustracking.model.Student;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Students")
public class StudentController {
    StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    @GetMapping
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
    @PutMapping()
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
}
