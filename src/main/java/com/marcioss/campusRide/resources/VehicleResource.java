package com.marcioss.campusRide.resources;

import com.marcioss.campusRide.entities.Vehicle;
import com.marcioss.campusRide.entities.dtos.inputDtos.VehicleDTO;
import com.marcioss.campusRide.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleResource {

    private final ModelMapper modelMapper;
    private final VehicleService vehicleService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> createVehicle(@RequestBody @Valid VehicleDTO vehicleDto){
        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
        var result = vehicleService.createvehicle(vehicle);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(vehicle.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
