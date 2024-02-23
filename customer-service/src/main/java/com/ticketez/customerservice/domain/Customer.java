package com.ticketez.customerservice.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String phoneNum;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private RoleType role;

    @Builder
    public Customer (String username, String password, String name, String phoneNum, String email){
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.role = RoleType.USER;
    }
}
