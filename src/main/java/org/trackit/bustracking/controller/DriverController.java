package org.trackit.bustracking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trackit.bustracking.ServiceImplementation.DriverService;
import org.trackit.bustracking.model.Driver;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Driver")
public class DriverController {
    DriverService driverService;
    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public Driver post(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }
    @GetMapping
    public List<Driver> getAll() {
        return driverService.getAllDrivers();
    }
    @GetMapping("/{id}")
    public Optional<Driver> get(@PathVariable int id) {
        return driverService.getDriverById(id);
    }
    @GetMapping("/user/{username}")
    public Optional<Driver> getByUsername(@PathVariable String username) {
        return driverService.getDriverByUsername(username);
    }
    @PutMapping
    public Driver put(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }
    @DeleteMapping("/{id}")
    public void delete( @PathVariable int id) {
        Optional<Driver> dv=driverService.getDriverById(id);
        driverService.deleteDriver(dv.orElse(null));
    }
}
