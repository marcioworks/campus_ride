package com.marcioss.campusRide.services;

import com.marcioss.campusRide.Security.UserSS;
import com.marcioss.campusRide.entities.Client;
import com.marcioss.campusRide.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final ClientRepository clientRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email);
        if(client == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(client.getId(),client.getEmail(),client.getPassword(),client.getPerfis());
    }
}
