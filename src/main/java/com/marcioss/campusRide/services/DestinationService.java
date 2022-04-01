package com.marcioss.campusRide.services;

import com.marcioss.campusRide.entities.Destination;
import com.marcioss.campusRide.repositories.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public List<Destination> findAllDestinations() {
        return destinationRepository.findAll();
    }
}
