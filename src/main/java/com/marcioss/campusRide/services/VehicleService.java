package com.marcioss.campusRide.services;

import com.marcioss.campusRide.entities.Vehicle;
import com.marcioss.campusRide.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle createvehicle(Vehicle vehicle) {
        vehicle = vehicleRepository.save(vehicle);
        return vehicle;
    }

    public List<Vehicle> findAllvehicles() {
        return vehicleRepository.findAll();
    }
}
