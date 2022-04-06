package com.marcioss.campusRide.entities.dtos.outputDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcioss.campusRide.entities.Client;
import com.marcioss.campusRide.entities.Destination;
import com.marcioss.campusRide.entities.Vehicle;
import com.marcioss.campusRide.entities.enums.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideOutputDTO {

    private Long id;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate date;
    private ShiftEnum shift;
    private Destination destination;
    private Vehicle vehicle;
}
