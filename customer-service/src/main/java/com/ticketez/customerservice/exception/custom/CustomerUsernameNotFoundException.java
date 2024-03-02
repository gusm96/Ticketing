package com.ticketez.customerservice.exception.custom;

import com.ticketez.customerservice.exception.ErrorCode;

public class CustomerUsernameNotFoundException extends CustomRuntimeException {
    public CustomerUsernameNotFoundException(ErrorCode errorCode){
        super(errorCode);
    }
}
