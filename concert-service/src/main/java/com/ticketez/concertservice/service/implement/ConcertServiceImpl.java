package com.ticketez.concertservice.service.implement;

import com.ticketez.concertservice.dto.ConcertDto;
import com.ticketez.concertservice.service.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConcertServiceImpl implements ConcertService {

    @Override
    public ConcertDto registerConcert(ConcertDto concertDto) {
        return null;
    }
}
