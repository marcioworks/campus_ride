package com.marcioss.campusRide.repositories;

import com.marcioss.campusRide.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride,Long> {

    Ride findByDestinationIdAndVehicleId(Long destinationId, Long vehicleId);
}
