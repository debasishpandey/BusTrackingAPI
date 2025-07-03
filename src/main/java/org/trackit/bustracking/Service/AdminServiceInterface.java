package org.trackit.bustracking.Service;


import org.trackit.bustracking.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminServiceInterface {
    Admin saveAdmin(Admin admin);
   Optional<Admin> findAdminById(long id);
   Optional<Admin> findAdminByUsername(String username);
   List<Admin> findAllAdmin();
   Admin updateAdmin(Admin admin);
   void deleteAdmin(Admin admin);
   boolean checkPassword(String password,String username);
}
