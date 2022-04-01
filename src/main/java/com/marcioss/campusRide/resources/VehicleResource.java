package com.marcioss.campusRide.resources;

import com.marcioss.campusRide.entities.Vehicle;
import com.marcioss.campusRide.entities.dtos.inputDtos.VehicleDTO;
import com.marcioss.campusRide.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleResource {

    private final ModelMapper modelMapper;
    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> listVehicles(){
        List<Vehicle> vehicles = vehicleService.findAllvehicles();
        return ResponseEntity.ok().body(vehicles);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> createVehicle(@RequestBody @Valid VehicleDTO vehicleDto){
        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
        var result = vehicleService.createvehicle(vehicle);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(vehicle.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
