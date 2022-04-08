package com.marcioss.campusRide.services;

import com.marcioss.campusRide.entities.Client;
import com.marcioss.campusRide.entities.dtos.outputDtos.ClientOutputDTO;
import com.marcioss.campusRide.entities.enums.Profile;
import com.marcioss.campusRide.repositories.ClientRepository;
import com.marcioss.campusRide.services.exceptions.DataIntegrityException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public Client createClient(Client client) throws DataIntegrityException {
        Client exists = clientRepository.findByEmail(client.getEmail());
        if(exists != null){
            throw new DataIntegrityException("Client Email Already registered, please insert a new Email");
        }
        client = clientRepository.save(client);
        return client;


    }

    public List<ClientOutputDTO> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientOutputDTO> result = clients
                .stream().map(e -> modelMapper.map(e, ClientOutputDTO.class))
                .collect(Collectors.toList());
        return result;
    }

    public Set<Profile> getRoles(String email) {
        var result = clientRepository.findByEmail(email);
        return result.getPerfis();

    }
}
