package org.trackit.bustracking.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackit.bustracking.Service.StudentServiceInterface;
import org.trackit.bustracking.model.Bus;
import org.trackit.bustracking.model.Student;
import org.trackit.bustracking.model.UserCredentials;
import org.trackit.bustracking.repository.StudentRepo;
import org.trackit.bustracking.utill.PasswordEncoder;

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
    public boolean checkPassword(String password,String username) {
            Optional<Student> student=studentRepo.findByUsername(username);

            if(student.isPresent()){

                return PasswordEncoder.checkPassword(password,student.get().getPassword());
            }
        return false;
    }

    public  Optional<Student> getStudentByRegistrationNumber(String registrationNumber) {
        return  studentRepo.findById(registrationNumber);
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

    public Bus getAssignedBus(String registrationNo) {
        Optional<Bus> bus = Optional.ofNullable(studentRepo.findBusByStudentRegistrationNo(registrationNo));
        return bus.get();
    }

    public Student getStudentByEmail(String email) {
        Optional<Student> student = studentRepo.findByEmail(email);
        return student.get();
    }
    public Student updateLocation(String username, double latitude, double longitude) {
        Student student = studentRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setLatitude(latitude);
        student.setLongitude(longitude);
        return studentRepo.save(student);
    }


}
