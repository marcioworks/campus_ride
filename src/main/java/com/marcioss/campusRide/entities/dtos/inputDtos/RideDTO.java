package com.marcioss.campusRide.entities.dtos.inputDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.marcioss.campusRide.entities.enums.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RideDTO {

    private Long id;
    @NotNull(message = "date can't be null")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate date;
    @NotNull(message = "user email can't be null")
    private String userEmail;
    @NotNull(message = "shift can't be empty")
    private ShiftEnum shift;
    @Digits(integer=4, fraction=0,message=" field can only contains digits")
    private Long destinationId;
    @Digits(integer=4, fraction=0,message=" field can only contains digits")
    private Long vehicleId;
    private Integer capacity;
}
