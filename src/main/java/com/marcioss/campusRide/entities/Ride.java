package com.marcioss.campusRide.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcioss.campusRide.entities.enums.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private ShiftEnum shift;

    @Column
    private Integer capacity;

    @OneToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}
