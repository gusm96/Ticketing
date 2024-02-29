package com.ticketez.concertservice.dto;


import com.ticketez.concertservice.domain.Concert;
import com.ticketez.concertservice.domain.Seat;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertRegisterDto {
    // 콘서트 이름
    @NotBlank(message = "콘서트 이름을 작성하세요.")
    private String concertName;

    // 콘서트 설명
    @NotBlank(message = "콘서트에 대한 설명을 작성해주세요.")
    private String description;

    // 콘서트 총 좌석 수
    @NotBlank(message = "총 좌석수를 입력하세요")
    private Integer totalSeats;

    // 좌석별 등급/좌석수/금액
    @NotBlank(message = "좌석 정보를 입력하세요.")
    private List<SeatDto> seatInfo;

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
