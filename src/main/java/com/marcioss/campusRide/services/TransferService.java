package com.marcioss.campusRide.services;

import com.marcioss.campusRide.Security.UserSS;
import com.marcioss.campusRide.entities.Destination;
import com.marcioss.campusRide.entities.Transfer;
import com.marcioss.campusRide.entities.Vehicle;
import com.marcioss.campusRide.entities.dtos.inputDtos.TransferDTO;
import com.marcioss.campusRide.entities.dtos.outputDtos.TransferOutputDTO;
import com.marcioss.campusRide.repositories.DestinationRepository;
import com.marcioss.campusRide.repositories.TransferRepository;
import com.marcioss.campusRide.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final  ModelMapper modelMapper;
    private final TransferRepository transferRepository;
    private final VehicleRepository vehicleRepository;
    private final DestinationRepository destinationRepository;

    public TransferOutputDTO createTransfer(TransferDTO transferDTO) {
        Transfer transfer = new Transfer();
        Vehicle vehicle = vehicleRepository.findById(transferDTO.getVehicleId()).orElse(null);
        Destination destination = destinationRepository.findById(transferDTO.getDestinationId()).orElse(null);
        transfer.setDestination(destination);
        transfer.setVehicle(vehicle);
        transfer.setShift(transferDTO.getShift());
        transfer.setDate(transferDTO.getDate());
        var result =transferRepository.save(transfer);
        TransferOutputDTO dto = modelMapper.map(result, TransferOutputDTO.class);
        return dto;
    }
}
