package com.ticketez.customerservice.exception.custom;


import com.ticketez.customerservice.exception.ErrorCode;

public class InvalidTokenException extends CustomRuntimeException {
    public InvalidTokenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
