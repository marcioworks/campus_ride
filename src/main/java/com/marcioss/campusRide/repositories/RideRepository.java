package com.marcioss.campusRide.repositories;

import com.marcioss.campusRide.entities.Ride;
import com.marcioss.campusRide.entities.enums.ShiftEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface RideRepository extends JpaRepository<Ride,Long> {

    Ride findByDestinationIdAndVehicleId(Long destinationId, Long vehicleId);

    Ride findByDestinationIdAndVehicleIdAndShift(Long destinationId, Long vehicleId, ShiftEnum shift);

    Ride findByDestinationIdAndVehicleIdAndShiftAndDate(Long destinationId, Long vehicleId, ShiftEnum shift, LocalDate date);
}
