package com.marcioss.campusRide.entities.dtos.inputDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDTO {

    @NotEmpty(message = "Field name can't be empty")
    private String name;

    @NotEmpty(message = "Field abbreviations can't be empty")
    private String abbreviations;
}
