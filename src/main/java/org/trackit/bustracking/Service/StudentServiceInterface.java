package org.trackit.bustracking.Service;

import org.trackit.bustracking.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServiceInterface {
    Student saveStudent(Student student);
    Optional<Student> getStudentByUsername(String username);
    Optional<Student> getStudentById(String id);
    List<Student> getAllStudents();
    void deleteStudent(String id);
    Student updateStudent( Student updatedStudent);
}
