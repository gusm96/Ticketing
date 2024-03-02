package com.ticketez.concertservice.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private int status;
    private String errorMessage;

    public static ResponseEntity<ErrorResponse> toResponseEntity(HttpStatus status, String errorMessage) {
        return ResponseEntity
                .status(status)
                .body(ErrorResponse.builder()
                        .status(status.value())
                        .errorMessage(errorMessage)
                        .build());
    }
}
