package com.marcioss.campusRide.services;

import com.marcioss.campusRide.entities.*;
import com.marcioss.campusRide.entities.dtos.inputDtos.RideDTO;
import com.marcioss.campusRide.entities.dtos.outputDtos.RideOutputDTO;
import com.marcioss.campusRide.repositories.*;
import com.marcioss.campusRide.services.exceptions.DataIntegrityException;
import com.marcioss.campusRide.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RideService {

    private final ModelMapper modelMapper;
    private final RideRepository rideRepository;
    private final VehicleRepository vehicleRepository;
    private final DestinationRepository destinationRepository;
    private final ScheduleRideRepository scheduleRideRepository;
    private final ClientRepository clientRepository;

    public RideOutputDTO createTransfer(RideDTO rideDTO) {
        RideOutputDTO dto = new RideOutputDTO();
        Ride alreadyExists = rideRepository.findByDestinationIdAndVehicleId( rideDTO.getDestinationId(),rideDTO.getVehicleId());
        if(alreadyExists == null) {
            var result = createNewTransfer(rideDTO);
            Ride ride = rideRepository.findById(result.getId()).orElse(null);
            scheduleRide(ride, rideDTO.getUserEmail());
            dto = result;
           return dto;
        }else{
           var result= scheduleRide(alreadyExists, rideDTO.getUserEmail());
            dto = result;
            return dto;
        }

    }

    private RideOutputDTO scheduleRide(Ride ride, String userEmail) {
        boolean rideIsFull = isFull(ride);
        if(rideIsFull){
            throw new DataIntegrityException("this ride is full, please chose another ride");
        }
        ScheduledRide scheduledRide = new ScheduledRide();
        Client client = clientRepository.findByEmail(userEmail);
        if(client == null){
            throw new NotFoundException("Client not Found");
        }
        scheduledRide.setRide(ride);
        scheduledRide.setClient(client);
        scheduleRideRepository.save(scheduledRide);
        RideOutputDTO dto = modelMapper.map(ride, RideOutputDTO.class);
        return dto;

    }

    private boolean isFull(Ride ride) {
        Integer rideFull = ride.getCapacity();
        List<ScheduledRide> schedulesRide = scheduleRideRepository.findAllByRideId(ride.getId());
        return schedulesRide.size() == rideFull;
    }

    private RideOutputDTO createNewTransfer(RideDTO rideDTO){
        Ride ride = new Ride();
        Vehicle vehicle = vehicleRepository.findById(rideDTO.getVehicleId()).orElse(null);
        Destination destination = destinationRepository.findById(rideDTO.getDestinationId()).orElse(null);
        ride.setDestination(destination);
        ride.setVehicle(vehicle);
        ride.setShift(rideDTO.getShift());
        ride.setDate(rideDTO.getDate());
        assert vehicle != null;
        ride.setCapacity(vehicle.getOccupation());
        var result = rideRepository.save(ride);
        RideOutputDTO dto = modelMapper.map(result, RideOutputDTO.class);
        return dto;
    }
}
