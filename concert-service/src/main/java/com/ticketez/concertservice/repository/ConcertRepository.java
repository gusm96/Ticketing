package com.ticketez.concertservice.repository;

import com.ticketez.concertservice.domain.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

}
