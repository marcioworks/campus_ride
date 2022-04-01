package com.marcioss.campusRide.resources;

import com.marcioss.campusRide.entities.Destination;
import com.marcioss.campusRide.entities.dtos.inputDtos.DestinationDTO;
import com.marcioss.campusRide.services.DestinationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/destinations")
@RequiredArgsConstructor
public class DestinationResource {

    private final DestinationService destinationService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Destination>> listDestinations(){
        var result = destinationService.findAllDestinations();
        return ResponseEntity.ok().body(result);

    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> createDestination(@RequestBody @Valid DestinationDTO destinationDTO){
        Destination destination = modelMapper.map(destinationDTO,Destination.class);
        var result = destinationService.createDestination(destination);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}").buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
