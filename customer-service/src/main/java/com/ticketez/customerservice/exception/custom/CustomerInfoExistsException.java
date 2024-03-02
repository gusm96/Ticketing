package com.ticketez.customerservice.exception.custom;

import com.ticketez.customerservice.exception.ErrorCode;

public class CustomerInfoExistsException extends CustomRuntimeException {
    public CustomerInfoExistsException(ErrorCode errorCode) {
        super(errorCode);
    }
}
