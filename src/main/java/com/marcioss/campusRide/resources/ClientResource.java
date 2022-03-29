package com.marcioss.campusRide.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {

    @GetMapping
    public ResponseEntity<?> Login(){
        return new ResponseEntity<>("teste", HttpStatus.OK);
    }
}
