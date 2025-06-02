package org.trackit.bustracking.Service;

import org.trackit.bustracking.model.Bus;

import java.util.List;
import java.util.Optional;

public interface BusServiceInterface {
    Bus saveBus(Bus bus);
    Optional<Bus> getBusById(int id);
    List<Bus> getAllBuses();
    void deleteBus(Bus bus);
    Bus updateBus(Bus bus);
}
