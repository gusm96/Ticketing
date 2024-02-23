package com.ticketez.customerservice.domain.jwt;


import com.ticketez.customerservice.domain.RoleType;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TokenInfo {
    private Long customerId;
    private RoleType roleType;
}
