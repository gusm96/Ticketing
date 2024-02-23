package com.ticketez.customerservice.exception;


import com.ticketez.customerservice.exception.custom.ExpiredTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerInfoIsExistsException.class)
    public ResponseEntity<?> handleCustomerInfoIsExistsException(CustomerInfoIsExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(ExpiredTokenException.class)
    public ResponseEntity<?> handleExpiredTokenException(ExpiredTokenException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
