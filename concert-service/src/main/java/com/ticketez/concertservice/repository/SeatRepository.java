package com.ticketez.concertservice.repository;

import com.ticketez.concertservice.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
