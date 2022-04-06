package com.marcioss.campusRide.repositories;

import com.marcioss.campusRide.entities.Client;
import com.marcioss.campusRide.entities.ScheduledRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRideRepository extends JpaRepository<ScheduledRide, Long> {
    List<ScheduledRide> findAllByRideId(Long id);

    @Query("SELECT C FROM ScheduledRide C WHERE client_id = :clientId")
    ScheduledRide findByClientId(@Param("clientId") Long clientId);

    @Query("SELECT R FROM ScheduledRide R WHERE client_id= :clientId")
    List<ScheduledRide> findAllByClientId(@Param("clientId") Long clientId);
}
