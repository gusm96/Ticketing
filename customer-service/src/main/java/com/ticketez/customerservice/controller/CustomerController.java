package com.ticketez.customerservice.controller;


import com.ticketez.customerservice.domain.JoinReqDto;
import com.ticketez.customerservice.domain.customer.LoginReqDto;
import com.ticketez.customerservice.service.CustomerService;
import com.ticketez.customerservice.util.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer-service")
public class CustomerController {
    private final CustomerService customerService;

    // 고객 등록
    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody @Valid JoinReqDto joinReqDto) {
        return ResponseEntity.ok().body(customerService.registerCustomer(joinReqDto));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody @Valid LoginReqDto loginReqDto, HttpServletResponse response) {
        String accessToken = customerService.login(loginReqDto);
        Cookie newCookie = CookieUtil.addCookie("access_token", accessToken);
        response.addCookie(newCookie);
        return ResponseEntity.ok().body("로그인 되었습니다.");
    }
    // 고객 조회


}
