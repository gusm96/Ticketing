package com.ticketez.customerservice.exception.custom;

import com.ticketez.customerservice.exception.ErrorCode;

public class ExpiredTokenException extends CustomRuntimeException {
    public ExpiredTokenException(ErrorCode errorCode){
        super(errorCode);
    }
}