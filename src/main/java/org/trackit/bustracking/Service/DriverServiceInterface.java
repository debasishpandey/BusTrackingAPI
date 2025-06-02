package org.trackit.bustracking.Service;

import org.trackit.bustracking.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverServiceInterface {
    Driver saveDriver(Driver driver);
    Optional<Driver> getDriverById(Integer id);
    Optional<Driver> getDriverByUsername(String username);
    List<Driver> getAllDrivers();
    void deleteDriver(Driver driver);
    Driver updateDriver(Driver driver);
}
