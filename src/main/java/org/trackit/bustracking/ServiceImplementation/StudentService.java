package org.trackit.bustracking.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackit.bustracking.Service.StudentServiceInterface;
import org.trackit.bustracking.model.Student;
import org.trackit.bustracking.repository.StudentRepo;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService implements StudentServiceInterface {

    StudentRepo studentRepo;

    @Autowired
   public void setStudentRepo(StudentRepo studentRepo) {
       this.studentRepo = studentRepo;
   }


    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Optional<Student> getStudentByUsername(String username) {
        return studentRepo.findByUsername(username);
    }

    @Override
    public Optional<Student> getStudentById(String id) {
        return studentRepo.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void deleteStudent(String id) {
         studentRepo.deleteById(id);
    }

    @Override
    public Student updateStudent(Student updatedStudent) {
        return studentRepo.save(updatedStudent) ;
    }


}
