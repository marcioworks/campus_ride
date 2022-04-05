package com.marcioss.campusRide.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledRide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="ride_id")
    private Ride ride;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
}
