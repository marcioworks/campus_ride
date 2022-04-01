package com.marcioss.campusRide.entities.dtos.inputDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    @NotEmpty(message = "field description can't be null")
    private String description;

    @Digits(integer=2, fraction=0,message=" field can only contains digits")
    private Integer occupation;
}
