package com.ticketez.customerservice.repository;

import com.ticketez.customerservice.domain.Customer;

import java.util.Optional;

public interface CustomerCustomRepository {
    Optional<Customer> findByUsername (String username);
}
