package org.trackit.bustracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trackit.bustracking.ServiceImplementation.AdminService;
import org.trackit.bustracking.model.Admin;
import org.trackit.bustracking.model.UserCredentials;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    AdminService adminService;
    @Autowired
    public void setAdminService(AdminService adminService) {this.adminService = adminService;}
    @PostMapping("/register")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }
    @PostMapping("/login")
    public boolean login(@RequestBody UserCredentials userCredentials) {
        return  adminService.checkPassword(userCredentials.getPassword(),userCredentials.getUsername());

    }
    @GetMapping
    public List<Admin> getAllAdmin() {
        return adminService.findAllAdmin();
    }
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable int id) {
        return adminService.findAdminById(id);
    }
    @PutMapping()
    public Optional<Admin> updateAdmin(@RequestBody Admin admin) {
        return Optional.ofNullable(adminService.updateAdmin(admin));
    }
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable int id) {
     Optional<Admin> f=   adminService.findAdminById(id);
        adminService.deleteAdmin(f.orElse(null));
    }

}
