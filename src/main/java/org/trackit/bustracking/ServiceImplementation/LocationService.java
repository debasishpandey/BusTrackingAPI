package org.trackit.bustracking.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackit.bustracking.Service.LocationServiceInterface;
import org.trackit.bustracking.model.Location;
import org.trackit.bustracking.repository.LocationRepo;

import java.util.Optional;
@Service
public class LocationService implements LocationServiceInterface {
    LocationRepo locationRepo;

    @Autowired
    public void setLocationRepo(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public Optional<Location> findLocationById(long id) {
        return locationRepo.findById(id);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationRepo.delete(location);
    }
}
