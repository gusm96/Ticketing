package com.ticketez.customerservice.exception.custom;

import com.ticketez.customerservice.exception.ErrorCode;
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
