package com.ticketez.concertservice.exception.custom;

import com.ticketez.concertservice.exception.ErrorCode;
public class ConcertNotFoundException extends CustomRuntimeException {
    public ConcertNotFoundException(ErrorCode errorCode){
        super(errorCode);
    }
}
