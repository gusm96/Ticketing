package com.ticketez.concertservice.exception.custom;

import com.ticketez.concertservice.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public abstract class CustomRuntimeException extends RuntimeException {
    protected ErrorCode errorCode;

    public CustomRuntimeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorCode.getErrorMessage();
    }

    public HttpStatus getHttpStatus() {
        return this.errorCode.getHttpStatus();
    }

}
