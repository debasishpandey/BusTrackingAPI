package org.trackit.bustracking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackit.bustracking.ServiceImplementation.BusService;
import org.trackit.bustracking.ServiceImplementation.DriverService;
import org.trackit.bustracking.model.Bus;
import org.trackit.bustracking.model.Driver;
import org.trackit.bustracking.model.UserCredentials;
import org.trackit.bustracking.utill.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/driver")
public class DriverController {
    DriverService driverService;

    @Autowired
    BusService busService;


    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/register")
    public Driver Register(@RequestBody Driver driver)
    {
        driver.setPassword(PasswordEncoder.encode(driver.getPassword()));
        return driverService.saveDriver(driver);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserCredentials userCredentials) {
        return driverService.checkPassword(userCredentials.getPassword(), userCredentials.getUsername());
    }
    @GetMapping("all")
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
    @PutMapping("/update")
    public ResponseEntity<Driver> put(@RequestBody Driver driver) {
       Driver updated= driverService.saveDriver(driver);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public void delete( @PathVariable int id) {
        Optional<Driver> dv=driverService.getDriverById(id);
        driverService.deleteDriver(dv.orElse(null));
    }

    @PutMapping("/update-status/{username}")
    public Bus updateStatus(@PathVariable String username) {
        Optional<Driver> dv=driverService.getDriverByUsername(username);
        if(dv.isPresent()) {
           long busId= dv.get().getBus().getId();
           Optional<Bus> bus=busService.getBusById(busId);
           bus.get().setStatus(!bus.get().getStatus());
           busService.saveBus(bus.get());
           return bus.get();
        }
        return null;
    }
}
