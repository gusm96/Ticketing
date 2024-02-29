package com.ticketez.concertservice.service;


import com.ticketez.concertservice.domain.Concert;
import com.ticketez.concertservice.domain.Seat;
import com.ticketez.concertservice.dto.ConcertRegisterDto;
import com.ticketez.concertservice.dto.SeatDto;
import com.ticketez.concertservice.repository.ConcertRepository;
import com.ticketez.concertservice.repository.SeatRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class ConcertServiceTest {
    @Autowired
    private ConcertRepository concertRepository;
    @Autowired
    private SeatRepository seatRepository;

    @Test
    @DisplayName("콘서트 등록")
    void registerConcertTest() {
        // given
        List<SeatDto> seatsDto = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            SeatDto seatDto = SeatDto.builder()
                    .SeatRating(i + "등급")
                    .count(i * 100)
                    .price(30000)
                    .build();
            seatsDto.add(seatDto);
        }
        ConcertRegisterDto concertRegisterDto = ConcertRegisterDto.builder()
                .concertName("콘서트")
                .description("콘서트입니다.")
                .totalSeats(500000) // 50만석
                .seatInfo(seatsDto)
                .startDate(LocalDateTime.parse("2024-03-08T00:00:00")) // 콘서트 시작일
                .endData(LocalDateTime.parse("2024-03-15T00:00:00")) // 콘서트 종료일
                .purchaseStartData(LocalDateTime.parse("2024-03-01T00:00:00")) // 콘서트 티켓 구매 시작일
                .purchaseEndData(LocalDateTime.parse("2024-03-05T00:00:00")) // 콘서트 티켓 구매 종료일
                .build();
        // when
        // 콘서트 저장
        Concert newConcert = concertRepository.save(concertRegisterDto.toEntity());
        // 좌석정보 생성
        List<SeatDto> seatDtoList = concertRegisterDto.getSeatInfo();
        List<Seat> seats = seatRepository.saveAll(seatDtoList.stream()
                .map(s -> s.toEntity(newConcert))
                .collect(Collectors.toList()));
        newConcert.setSeats(seats);
        // 성공 시 콘서트 티켓 반환

        // then
        assertThat(newConcert.getId()).isEqualTo(seats.get(0).getConcert().getId());
    }
}
