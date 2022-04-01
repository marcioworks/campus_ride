package com.marcioss.campusRide.services;

import com.marcioss.campusRide.entities.Vehicle;
import com.marcioss.campusRide.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle createvehicle(Vehicle vehicle) {
        vehicle = vehicleRepository.save(vehicle);
        return vehicle;
    }
}
