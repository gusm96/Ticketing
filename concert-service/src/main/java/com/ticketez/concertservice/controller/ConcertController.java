package com.ticketez.concertservice.controller;


import com.ticketez.concertservice.dto.ConcertDto;
import com.ticketez.concertservice.dto.ConcertRegisterDto;
import com.ticketez.concertservice.service.ConcertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/concert-service")
public class ConcertController {
    private final ConcertService concertService;

    // 콘서트 등록
    @GetMapping("/register")
    public ResponseEntity<?> registerConcert(@RequestBody @Valid ConcertRegisterDto concertRegisterDto){
        return ResponseEntity.ok().body(concertService.registerConcert(concertRegisterDto));
    }
    // 콘서트
    @GetMapping("/concerts/{concertId}")
    public ResponseEntity<ConcertDto> getConcertInfo(@PathVariable("concertId") Long concertId){
        return ResponseEntity.ok().body(concertService.retrieveConcertById(concertId));
    }
    // 전체 콘서트 조회

    // 카테고리별 콘서트 조회

    // 콘서트 검색

    // 콘서트 수정

    // 콘서트 삭제

}
