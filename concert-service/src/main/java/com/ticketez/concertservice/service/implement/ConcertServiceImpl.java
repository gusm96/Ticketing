package com.ticketez.concertservice.service.implement;

import com.ticketez.concertservice.domain.Concert;
import com.ticketez.concertservice.domain.Seat;
import com.ticketez.concertservice.dto.ConcertDto;
import com.ticketez.concertservice.dto.ConcertRegisterDto;
import com.ticketez.concertservice.dto.SeatDto;
import com.ticketez.concertservice.repository.ConcertRepository;
import com.ticketez.concertservice.repository.SeatRepository;
import com.ticketez.concertservice.service.ConcertService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ConcertServiceImpl implements ConcertService {
    private final ConcertRepository concertRepository;
    private final SeatRepository seatRepository;

    @Override
    @Transactional
    public ConcertRegisterDto registerConcert(ConcertRegisterDto concertRegisterDto) {
        try {
            Concert newConcert = concertRepository.save(concertRegisterDto.toEntity());
            List<SeatDto> seatDtoList = concertRegisterDto.getSeatInfo();
            List<Seat> seats = seatRepository.saveAll(
                    seatDtoList.stream()
                            .map(s -> s.toEntity(newConcert))
                            .collect(Collectors.toList())
            );
            newConcert.setSeats(seats);
            return concertRegisterDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ConcertDto retrieveConcertById(Long concertId) {
        Concert findConcert = concertRepository.findById(concertId).orElseThrow(
                () -> new NotFoundException("요청하신 콘서트 정보가 존재하지 않습니다.")
        );
        return ConcertDto.builder()
                .concert(findConcert)
                .build();
    }
}
