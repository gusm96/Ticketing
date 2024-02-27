package com.ticketez.concertservice.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seatRating;
    private Integer count;
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Concert concert;
}
