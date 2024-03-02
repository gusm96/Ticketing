package com.ticketez.customerservice.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    // Http Status 400
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    // Http Status 403
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다."),
    TOKEN_IS_EXPIRATION(HttpStatus.UNAUTHORIZED, "토큰이 만료되었습니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "권한이 없습니다."),
    INVALID_SIGNATURE(HttpStatus.UNAUTHORIZED, "토큰의 서명이 올바르지 않습니다."),
    INVALID_TOKEN_STRUCTURE(HttpStatus.UNAUTHORIZED, "토큰의 구조가 올바르지 않습니다."),

    // Http Status 404
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 아이디입니다."),

    // Http Status 409
    USERNAME_EXISTS(HttpStatus.CONFLICT, "이미 등록된 아이디입니다."),
    EMAIL_EXISTS(HttpStatus.CONFLICT, "이미 등록된 이메일입니다."),
    PHONE_NUMBER_EXISTS(HttpStatus.CONFLICT, "이미 등록된 전화번호입니다.");


    private final HttpStatus httpStatus;
    private final String errorMessage;
}
