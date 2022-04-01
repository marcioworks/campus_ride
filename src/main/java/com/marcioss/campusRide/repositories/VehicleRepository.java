package com.marcioss.campusRide.repositories;

import com.marcioss.campusRide.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
