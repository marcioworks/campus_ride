package com.marcioss.campusRide.entities.dtos.inputDtos;

import com.marcioss.campusRide.entities.Destination;
import com.marcioss.campusRide.entities.Vehicle;
import com.marcioss.campusRide.entities.enums.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.bridge.Message;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferDTO {

    @NotNull(message = "date can't be null")
    private Date date;
    @NotNull(message = "shift can't be empty")
    private ShiftEnum shift;
    @Digits(integer=4, fraction=0,message=" field can only contains digits")
    private Long destinationId;
    @Digits(integer=4, fraction=0,message=" field can only contains digits")
    private Long vehicleId;
}
