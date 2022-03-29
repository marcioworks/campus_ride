package com.marcioss.campusRide.entities.dtos.outputDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientOutputDTO {

    private Long id;
    private String name;
    private String email;
}
