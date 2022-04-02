package com.marcioss.campusRide.repositories;

import com.marcioss.campusRide.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer,Long> {
}
