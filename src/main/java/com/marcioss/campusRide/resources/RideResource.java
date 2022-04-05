package com.marcioss.campusRide.resources;

import com.marcioss.campusRide.entities.dtos.inputDtos.RideDTO;
import com.marcioss.campusRide.entities.dtos.outputDtos.RideOutputDTO;
import com.marcioss.campusRide.services.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transfers")
@RequiredArgsConstructor
public class RideResource {

    private final RideService rideService;
    @PostMapping
    public ResponseEntity<RideOutputDTO> createTransfer(@RequestBody @Valid RideDTO rideDTO){
        var result = rideService.createTransfer(rideDTO);
        return  ResponseEntity.ok().body(result);
    }
//
//    @GetMapping
//    public ResponseEntity<List<Ride>> getTransfersBy
}
