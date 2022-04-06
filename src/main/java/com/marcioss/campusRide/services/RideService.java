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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
        Ride alreadyExists = rideRepository
                .findByDestinationIdAndVehicleIdAndShiftAndDate( rideDTO.getDestinationId(),rideDTO.getVehicleId(),rideDTO.getShift(),rideDTO.getDate());
        if(alreadyExists == null) {
            var result = createNewTransfer(rideDTO);
            Ride ride = rideRepository.findById(result.getId()).orElse(null);
            scheduleRide(ride, rideDTO);
            dto = result;
           return dto;
        }else{
           var result= scheduleRide(alreadyExists, rideDTO);
            dto = result;
            return dto;
        }

    }

    private RideOutputDTO scheduleRide(Ride ride, RideDTO rideDTO) {
        boolean rideIsFull = isFull(ride);
        if(rideIsFull){
            throw new DataIntegrityException("this ride is full, please chose another ride");
        }
        Client client = clientRepository.findByEmail(rideDTO.getUserEmail());
        if(client == null){
            throw new NotFoundException("Client not Found");
        }
        boolean clientExists = clientExists(client.getId(),rideDTO);
        if(clientExists){
            throw new DataIntegrityException("You already have a Scheduled ride!");
        }
        ScheduledRide scheduledRide = new ScheduledRide();

        scheduledRide.setRide(ride);
        scheduledRide.setClient(client);
        scheduleRideRepository.save(scheduledRide);
        RideOutputDTO dto = modelMapper.map(ride, RideOutputDTO.class);
        return dto;

    }

    private boolean clientExists(Long clientId, RideDTO rideDTO) {
        List<ScheduledRide> result = scheduleRideRepository.findAllByClientId(clientId);
        if(result.size() > 0){
            LocalDate rideDate =rideDTO.getDate();
           boolean sameDay =  result.stream().anyMatch(scheduledRide -> scheduledRide.getRide().getDate().isEqual(rideDate));
           boolean sameShift =  result.stream().anyMatch(scheduledRide -> scheduledRide.getRide().getShift() == rideDTO.getShift());
            if (sameDay && sameShift){
                return true;
            }
        }
        return false;

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
