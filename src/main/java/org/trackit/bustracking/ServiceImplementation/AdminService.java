package org.trackit.bustracking.ServiceImplementation;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackit.bustracking.Service.AdminServiceInterface;
import org.trackit.bustracking.model.Admin;
import org.trackit.bustracking.repository.AdminRepo;
import org.trackit.bustracking.utill.PasswordEncoder;

import java.util.List;
import java.util.Optional;
@Service
public class AdminService implements AdminServiceInterface {


    @PostConstruct
    public void init() {
        System.out.println("✅ FacultyService loaded into Spring context");
    }

    AdminRepo adminRepo;

//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    public void setAdminRepo(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }



    @Override
    public Admin saveAdmin(Admin admin) {
        admin.setPassword(PasswordEncoder.encode(admin.getPassword()));
        return adminRepo.save(admin);
    }

    @Override
    public Optional<Admin> findAdminById(long id) {
        return adminRepo.findById(id);
    }

    @Override
    public Optional<Admin> findAdminByUsername(String username) {
        return adminRepo.findAdminByUsername(username);
    }

    @Override
    public List<Admin> findAllAdmin() {
        return adminRepo.findAll();
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        adminRepo.delete(admin);
    }

    @Override
    public boolean checkPassword(String password,String username) {
       Optional<Admin> f= adminRepo.findAdminByUsername(username);
       if(f.isPresent()){
            return PasswordEncoder.checkPassword(password,f.get().getPassword());
       }
        System.out.println(username);
        return false;
    }


}
