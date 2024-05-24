package org.example.controller;

import org.example.entity.subscriber.dto.ErrorResponse;
import org.example.exception.InternalTechnicalErrorException;
import org.example.exception.InvalidOtpException;
import org.example.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler({
            NullPointerException.class,
            IllegalArgumentException.class,
            NumberFormatException.class,
            InvalidOtpException.class})
    public ResponseEntity<ErrorResponse> invalidHandler(Throwable ex) {
        ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.toString());
        return new ResponseEntity<>(response, BAD_REQUEST);
    }

    @ExceptionHandler({
            NotFoundException.class})
    public ResponseEntity<ErrorResponse> notFoundExceptionHandler(Throwable ex) {
        ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.toString());
        return new  ResponseEntity<>(response, NOT_FOUND);
    }

    @ExceptionHandler(InternalTechnicalErrorException.class)
    public ResponseEntity<ErrorResponse> internalExceptionHandler(Throwable ex) {
        ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.toString());
        return new ResponseEntity<>(response, INTERNAL_SERVER_ERROR);
    }
}

