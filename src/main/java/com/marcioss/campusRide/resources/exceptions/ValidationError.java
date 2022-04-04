package com.marcioss.campusRide.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationError  extends StandardError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Long timeStamps, Integer status, String error, String message, String path) {
        super(timeStamps, status, error, message, path);
        // TODO Auto-generated constructor stub
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message ) {
        errors.add(new FieldMessage(fieldName, message));
    }

}
