package com.ticketez.customerservice.domain.jwt;


import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Token {
    private String accessToken;
    private String refreshToken;
}
