package com.ticketez.concertservice.dto;


import com.ticketez.concertservice.domain.Concert;
import com.ticketez.concertservice.domain.Seat;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatDto {
    // 좌석 등급
    private String SeatRating;
    // 좌석 수
    private Integer count;
    // 좌석 금액
    private Integer price;

    public Seat toEntity(Concert concert){
        return Seat.builder()
                .seatRating(this.SeatRating)
                .count(this.count)
                .price(this.price)
                .concert(concert)
                .build();
    }

}
