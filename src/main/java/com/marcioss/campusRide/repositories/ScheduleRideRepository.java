package com.marcioss.campusRide.repositories;

import com.marcioss.campusRide.entities.ScheduledRide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRideRepository extends JpaRepository<ScheduledRide, Long> {
    List<ScheduledRide> findAllByRideId(Long id);
}
