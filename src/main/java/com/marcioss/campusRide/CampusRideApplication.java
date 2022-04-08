package com.marcioss.campusRide;

import com.marcioss.campusRide.entities.Client;
import com.marcioss.campusRide.entities.enums.Profile;
import com.marcioss.campusRide.repositories.ClientRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
@OpenAPIDefinition
public class CampusRideApplication implements CommandLineRunner {

	private final ClientRepository clientRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(CampusRideApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client client = new Client();
		client.setName("admin");
		client.setEmail("admin@admin.com");
		client.setPassword(passwordEncoder.encode("123456"));
		client.addProfile(Profile.ADMIN);
		clientRepository.save(client);
	}
}
