package com.ticketez.concertservice.repository;

import com.ticketez.concertservice.domain.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

    @Query("select distinct c from Concert c " +
            "left join Seat s on s.concert.id = :concertId " +
            "where c.id = :concertId ")
    Optional<Concert> findById(Long concertId);
}
