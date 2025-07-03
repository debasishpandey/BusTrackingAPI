package org.trackit.bustracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trackit.bustracking.ServiceImplementation.BusService;
import org.trackit.bustracking.model.Bus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "*")
public class BusController {
    @Autowired
    BusService busService;

    @GetMapping("all")
    public List<Bus> getBuses() {
        return busService.getAllBuses();
    }

    @PostMapping("register")
    public Bus addBus(@RequestBody Bus bus) {
        return busService.saveBus(bus);
    }
    @PutMapping("update")
    public Bus updateBus(@RequestBody Bus bus) {
        return busService.updateBus(bus);
    }
    @GetMapping("/{id}")
    public Optional<Bus> getBus(@PathVariable int id) {
        return busService.getBusById(id);
    }


}
