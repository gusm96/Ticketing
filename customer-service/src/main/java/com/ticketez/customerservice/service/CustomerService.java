package com.ticketez.customerservice.service;

import com.ticketez.customerservice.domain.JoinReqDto;
import com.ticketez.customerservice.domain.customer.LoginReqDto;

public interface CustomerService {

    Long registerCustomer(JoinReqDto joinReqDto);

    String login(LoginReqDto loginReqDto);
}
