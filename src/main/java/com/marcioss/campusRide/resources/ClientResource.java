package com.marcioss.campusRide.resources;

import com.marcioss.campusRide.entities.Client;
import com.marcioss.campusRide.entities.dtos.inputDtos.ClientDTO;
import com.marcioss.campusRide.entities.dtos.outputDtos.ClientOutputDTO;
import com.marcioss.campusRide.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientResource {

    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder pe;
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Void> createClient(@RequestBody @Valid ClientDTO clientDTO){
        Client client = modelMapper.map(clientDTO,Client.class);
        client.setPassword(pe.encode(client.getPassword()));
        var result = clientService.createClient(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
