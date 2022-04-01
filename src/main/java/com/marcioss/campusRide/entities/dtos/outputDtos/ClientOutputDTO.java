package com.marcioss.campusRide.entities.dtos.outputDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientOutputDTO {

    private Long id;
    private String name;
    private String email;
}
