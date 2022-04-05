package com.marcioss.campusRide.resources.exceptions;

import com.marcioss.campusRide.services.exceptions.DataIntegrityException;
import com.marcioss.campusRide.services.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> authorization(DataIntegrityException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(), "Data integrity", request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> notFound(NotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(), "Not Found", request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
