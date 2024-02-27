package com.ticketez.concertservice.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // 좌석 등급
    private String rating;
    // 금액
    private int price;
    // 구매 일
    private LocalDateTime purchaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    public Concert concert;

}
