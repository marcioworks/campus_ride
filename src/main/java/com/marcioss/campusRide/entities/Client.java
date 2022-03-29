package com.marcioss.campusRide.entities;

import com.marcioss.campusRide.entities.enums.Profile;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profiles")
    private Set<Integer> profiles = new HashSet<>();

    public Client() {
        addProfile(Profile.STUDENT);
    }

    public void addProfile(Profile profile) {
        profiles.add(profile.getCod());
    }

    public Set<Profile> getPerfis() {
        return profiles.stream().map(Profile::toEnum).collect(Collectors.toSet());
    }

}
