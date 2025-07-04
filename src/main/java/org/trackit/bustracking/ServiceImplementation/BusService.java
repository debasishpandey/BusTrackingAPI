package org.trackit.bustracking.ServiceImplementation;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackit.bustracking.Service.BusServiceInterface;
import org.trackit.bustracking.model.Bus;
import org.trackit.bustracking.model.Driver;
import org.trackit.bustracking.repository.BusRepo;
import org.trackit.bustracking.repository.DriverRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BusService implements BusServiceInterface {
     @Autowired
    DriverRepo driverRepo;

    BusRepo busRepo;
    @Autowired
    public void setBusRepo(BusRepo busRepo) {
        this.busRepo = busRepo;
    }
    @Override
    public Bus saveBus(Bus bus) {
        return busRepo.save(bus);
    }

    @Override
    public Optional<Bus> getBusById(long id) {
        return busRepo.findById(id);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepo.findAll();
    }

    @Override
    public void deleteBus(Bus bus) {
        busRepo.delete(bus);
    }

    @Override
    public Bus updateBus(Bus bus) {
        return busRepo.save(bus);
    }
    public Bus updateBusLocation(String driverUsername, double latitude, double longitude) {
        Driver driver = driverRepo.findByUsername(driverUsername)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        Bus bus = driver.getBus();
        bus.setLatitude(latitude);
        bus.setLongitude(longitude);
        return busRepo.save(bus);
    }
    @Transactional
    public void deleteById(int id) {
        busRepo.deleteById(id);
    }
}
