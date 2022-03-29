package com.marcioss.campusRide.repositories;


import com.marcioss.campusRide.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface ClientRepository extends JpaRepository<Client, Long> {

    @Transactional(readOnly=true)
    Client findByEmail(String email);
}
