package com.marcioss.campusRide.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShiftEnum {
    MORNING(1,"MANHA"),
    AFTERNOON(2,"TARDE"),
    EVENING(3, "NOITE");

    private final Integer code;
    private final String description;

    ShiftEnum(int code, String descripton) {
        this.code= code;
        this.description= descripton;
    }
}
