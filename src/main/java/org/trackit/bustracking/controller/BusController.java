package org.trackit.bustracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackit.bustracking.ServiceImplementation.BusService;
import org.trackit.bustracking.model.Bus;
import org.trackit.bustracking.model.Student;
import org.trackit.bustracking.repository.BusRepo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/bus")
public class BusController {
    @Autowired
    BusService busService;

    @Autowired
    BusRepo busRepo;

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
    @PutMapping("/update-location/{driverUsername}")
    public ResponseEntity<Bus> updateBusLocation(@PathVariable String driverUsername, @RequestBody Map<String, Double> location) {
        double lat = location.get("latitude");
        double lon = location.get("longitude");
        Bus updatedBus = busService.updateBusLocation(driverUsername, lat, lon);
        return ResponseEntity.ok(updatedBus);
    }

    @GetMapping("/{busId}/students")
    public ResponseEntity<List<Student>> getStudentsByBusId(@PathVariable Long busId) {
        Optional<Bus> busOpt = busRepo.findById(busId);
        if (busOpt.isPresent()) {
            List<Student> students = busOpt.get().getStudents();
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBus(@PathVariable int id) {



            busService.deleteById(id);


        return ResponseEntity.noContent().build();
    }
}
