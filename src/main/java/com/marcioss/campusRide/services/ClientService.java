package com.marcioss.campusRide.services;

import com.marcioss.campusRide.entities.Client;
import com.marcioss.campusRide.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client createClient(Client client) {
        client = clientRepository.save(client);
        return client;


    }
}
