package com.ticketez.concertservice.service.implement;

import com.ticketez.concertservice.domain.Concert;
import com.ticketez.concertservice.domain.Seat;
import com.ticketez.concertservice.dto.ConcertDto;
import com.ticketez.concertservice.repository.ConcertRepository;
import com.ticketez.concertservice.repository.SeatRepository;
import com.ticketez.concertservice.service.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertServiceImpl implements ConcertService {
    private final ConcertRepository concertRepository;
    private final SeatRepository seatRepository;

    @Override
    public ConcertDto registerConcert(ConcertDto concertDto) {
        try {
            Concert newConcert = concertRepository.save(concertDto.toConcertEntity());
            List<Seat> seats = seatRepository.saveAll(concertDto.toSeatEntityList(newConcert));
            newConcert.setSeats(seats);
            return concertDto;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
