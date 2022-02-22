package com.prueba.manomano.controller;

import com.prueba.manomano.exception.DateTimeConversionException;
import com.prueba.manomano.exception.DateTimeConversionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DateTimeConversionResponse> handleDateTimeConversionException(final DateTimeConversionException e) {

        DateTimeConversionResponse response =
                DateTimeConversionResponse.builder()
                        .message(e.getMessage())
                        .code("INVALID DATETIME")
                        .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
