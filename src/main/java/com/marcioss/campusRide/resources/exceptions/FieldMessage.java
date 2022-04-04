package com.marcioss.campusRide.resources.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class FieldMessage {

    private String fieldName;
    private String message;

    public FieldMessage() {}

    public FieldMessage(String fieldName, String message) {
        super();
        this.fieldName = fieldName;
        this.message = message;
    }
}
