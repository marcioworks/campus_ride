package com.marcioss.campusRide.resources;

import com.marcioss.campusRide.entities.Transfer;
import com.marcioss.campusRide.entities.dtos.inputDtos.TransferDTO;
import com.marcioss.campusRide.entities.dtos.outputDtos.TransferOutputDTO;
import com.marcioss.campusRide.services.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transfers")
@RequiredArgsConstructor
public class TransferResource {

    private final TransferService transferService;
    @PostMapping
    public ResponseEntity<TransferOutputDTO> createTransfer(@RequestBody @Valid TransferDTO transferDTO){
        var result = transferService.createTransfer(transferDTO);
        return  ResponseEntity.ok().body(result);
    }
}
