package org.trackit.bustracking.Service;

import org.trackit.bustracking.model.Location;

import java.util.Optional;

public interface LocationServiceInterface {
    Location saveLocation(Location location);
    Optional<Location> findLocationById(long id);
    Location updateLocation(Location location);
    void deleteLocation(Location location);

}
