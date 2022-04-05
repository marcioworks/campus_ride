package com.marcioss.campusRide.entities;

import com.marcioss.campusRide.entities.enums.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Date date;

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
