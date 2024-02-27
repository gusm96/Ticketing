package com.ticketez.concertservice.dto;


import com.ticketez.concertservice.domain.Concert;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertDto {
    private String concertName;
    private String description;
    private Integer totalSeats;
    // 콘서트 시작일
    private LocalDateTime startDate;
    // 콘서트 종료일
    private LocalDateTime endData;
    // 티켓 구매 시작일
    private LocalDateTime purchaseStartData;
    // 티켓 구매 종료일
    private LocalDateTime purchaseEndData;


    public Concert toEntity(){
        return Concert.builder()
                .concertName(this.concertName)
                .description(this.description)
                .totalSeats(this.totalSeats)
                .startDate(this.startDate)
                .endDate(this.endData)
                .purchaseStartData(this.purchaseStartData)
                .purchaseEndData(this.purchaseEndData)
                .build();
    }
}
