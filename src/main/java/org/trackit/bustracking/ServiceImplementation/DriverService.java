package org.trackit.bustracking.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackit.bustracking.Service.DriverServiceInterface;
import org.trackit.bustracking.model.Driver;
import org.trackit.bustracking.repository.DriverRepo;

import java.util.List;
import java.util.Optional;


@Service
public class DriverService implements DriverServiceInterface {

   DriverRepo driverRepo;
   @Autowired
        public void setDriverRepo(DriverRepo driverRepo) {
            this.driverRepo = driverRepo;
        }

    @Override
    public Driver saveDriver(Driver driver) {
        return driverRepo.save(driver);
    }

    @Override
    public Optional<Driver> getDriverById(Integer id) {
        return driverRepo.findById(id);
    }

    @Override
    public Optional<Driver> getDriverByUsername(String username) {
        return driverRepo.findByUsername(username);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepo.findAll();
    }

    @Override
    public void deleteDriver(Driver driver) {
        driverRepo.delete(driver);
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return driverRepo.save(driver);
    }
}
