package com.ticketez.concertservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    CONCERT_NOT_FOUND("요청하신 콘서트 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
    private String errorMessage;
    private HttpStatus httpStatus;
    ErrorCode(String errorMessage, HttpStatus httpStatus){
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }
}
