package com.ticketez.customerservice.exception;


import com.ticketez.customerservice.exception.custom.CustomerInfoExistsException;
import com.ticketez.customerservice.exception.custom.ExpiredTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerInfoExistsException.class)
    public ResponseEntity<ErrorResponse> handleCustomerInfoExistsException(CustomerInfoExistsException e) {
        return ErrorResponse.toResponseEntity(e.getHttpStatus(), e.getErrorMessage());
    }

    @ExceptionHandler(ExpiredTokenException.class)
    public ResponseEntity<ErrorResponse> handleExpiredTokenException(ExpiredTokenException e){
        return ErrorResponse.toResponseEntity(e.getHttpStatus(), e.getErrorMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException e){
        return ErrorResponse.toResponseEntity(HttpStatus.UNAUTHORIZED, e.getMessage());
    }
}
