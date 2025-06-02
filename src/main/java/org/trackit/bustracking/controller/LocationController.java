package org.trackit.bustracking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trackit.bustracking.ServiceImplementation.LocationService;
import org.trackit.bustracking.model.Location;

import java.util.Optional;

@RestController
@RequestMapping("/Location")
public class LocationController {
    LocationService locationService;
    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }
    @GetMapping("/{id}")
    public Optional<Location> getLocations(@PathVariable int id) {
        return locationService.findLocationById(id);
    }
    @PutMapping
    public Location updateLocation(@RequestBody Location location) {
        return locationService.updateLocation(location);
    }
    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable int id) {
        Optional<Location> loc=locationService.findLocationById(id);
        locationService.deleteLocation(loc.orElse(null));
    }
}
