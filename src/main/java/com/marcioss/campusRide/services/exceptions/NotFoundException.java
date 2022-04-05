package com.marcioss.campusRide.services.exceptions;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
