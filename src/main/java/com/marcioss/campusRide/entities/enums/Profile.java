package com.marcioss.campusRide.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Profile {

    ADMIN(1,"ADMIN"),
    STUDENT(2, "ALUNO");
    
    private Integer cod;
    private String description;

    public static Profile toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Profile x : Profile.values()) {
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid cod: "+ cod);
    }
}
