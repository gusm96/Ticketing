package com.ticketez.concertservice.service;

import com.ticketez.concertservice.dto.ConcertRegisterDto;

public interface ConcertService {

    ConcertRegisterDto registerConcert(ConcertRegisterDto concertRegisterDto);

}
