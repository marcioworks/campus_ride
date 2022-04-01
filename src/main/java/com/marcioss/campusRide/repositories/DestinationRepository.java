package com.marcioss.campusRide.repositories;

import com.marcioss.campusRide.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination,Long> {
}
