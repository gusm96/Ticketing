package com.ticketez.concertservice.controller;


import com.ticketez.concertservice.dto.ConcertDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/concert-service")
public class ConcertController {

    // 콘서트 등록
    @GetMapping("/register")
    public ResponseEntity<?> registerConcert(@RequestBody @Valid ConcertDto concertDto){

    }
    // 콘서트 조회
    // 전체 콘서트 조회
    // 콘서트 수정
    // 콘서트 삭제
}
