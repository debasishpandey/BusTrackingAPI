package org.trackit.bustracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trackit.bustracking.ServiceImplementation.BusService;
import org.trackit.bustracking.model.Bus;

import java.util.List;

@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "*")
public class BusController {
    @Autowired
    BusService busService;

    @GetMapping
    public List<Bus> getBuses() {
        return busService.getAllBuses();
    }

}
