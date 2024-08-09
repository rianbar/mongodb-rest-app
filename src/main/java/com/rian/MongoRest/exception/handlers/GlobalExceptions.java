package com.rian.MongoRest.exception.handlers;

import com.rian.MongoRest.exception.templates.ErrorTemplate;
import com.rian.MongoRest.exception.errors.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorTemplate> userNotFoundExceptionHandler(CustomerNotFoundException ex) {
        var error = ErrorTemplate.builder().code(404).type("NOT_FOUND").message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
