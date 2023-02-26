package com.example.swaggerproject.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class IcecreamExceptionHandler {

    @ExceptionHandler(IcecreamRequestException.class)
    public ResponseEntity<Object> handleIcecreamserviceException(IcecreamRequestException e) {
        IcecreamExceptionResponse icecreamExceptionResponse = new IcecreamExceptionResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(icecreamExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
