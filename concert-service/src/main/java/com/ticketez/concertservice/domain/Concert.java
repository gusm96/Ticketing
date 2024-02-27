package com.ticketez.concertservice.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 콘서트 이름
    private String concertName;
    // 콘서트 설명
    private String description;
    // 총 좌석 수
    private Integer totalSeats;
    // 콘서트 등록일
    private LocalDateTime registrationDate;
    // 콘서트 시작일
    private LocalDateTime startDate;
    // 콘서트 종료일
    private LocalDateTime endData;
    // 티켓 구매 시작일
    private LocalDateTime purchaseStartData;
    // 티켓 구매 종료일
    private LocalDateTime purchaseEndData;

    @Builder
    public Concert(String concertName, String description, int totalSeats, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime purchaseStartData, LocalDateTime purchaseEndData) {
        this.concertName = concertName;
        this.description = description;
        this.totalSeats = totalSeats;
        this.registrationDate = LocalDateTime.now();
        this.startDate = startDate;
        this.endData = endDate;
        this.purchaseStartData = purchaseStartData;
        this.purchaseEndData = purchaseEndData;
    }

}
