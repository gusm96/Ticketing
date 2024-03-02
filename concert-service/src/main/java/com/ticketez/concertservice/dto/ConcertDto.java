package com.ticketez.concertservice.dto;


import com.ticketez.concertservice.domain.Concert;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertDto {
    // 콘서트 아이디
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

    private List<SeatDto> seatDtoList;

    @Builder
    public ConcertDto(Concert concert) {
        this.id = concert.getId();
        this.concertName = concert.getConcertName();
        this.description = concert.getDescription();
        this.totalSeats = concert.getTotalSeats();
        this.registrationDate = concert.getRegistrationDate();
        this.startDate = concert.getStartDate();
        this.endData = concert.getEndData();
        this.purchaseStartData = concert.getPurchaseStartDate();
        this.purchaseEndData = concert.getPurchaseEndDate();
        this.seatDtoList = concert.getSeats().stream().map(
                s -> SeatDto.builder()
                        .SeatRating(s.getSeatRating())
                        .count(s.getCount())
                        .price(s.getPrice())
                        .build()
        ).collect(Collectors.toList());
    }
}
