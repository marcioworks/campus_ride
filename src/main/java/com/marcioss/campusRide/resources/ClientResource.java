package com.marcioss.campusRide.resources;

import com.marcioss.campusRide.entities.Client;
import com.marcioss.campusRide.entities.dtos.inputDtos.ClientDTO;
import com.marcioss.campusRide.entities.dtos.outputDtos.ClientOutputDTO;
import com.marcioss.campusRide.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientResource {

    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder pe;
    private final ClientService clientService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<List<ClientOutputDTO>> ListClients(){
        var result = clientService.findAllClients();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> createClient(@RequestBody @Valid ClientDTO clientDTO){
        Client client = modelMapper.map(clientDTO,Client.class);
        client.setPassword(pe.encode(client.getPassword()));
        var result = clientService.createClient(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
