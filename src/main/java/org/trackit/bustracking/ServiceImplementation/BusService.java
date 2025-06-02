package org.trackit.bustracking.ServiceImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackit.bustracking.Service.BusServiceInterface;
import org.trackit.bustracking.model.Bus;
import org.trackit.bustracking.repository.BusRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BusService implements BusServiceInterface {

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
    public Optional<Bus> getBusById(int id) {
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
}
