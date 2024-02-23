package com.ticketez.customerservice.domain;


import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class JoinReqDto {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNum;

    public Customer toEntity(String encodedPassword){
        return Customer.builder()
                .username(this.username)
                .password(encodedPassword)
                .name(this.name)
                .email(this.email)
                .phoneNum(this.phoneNum)
                .build();
    }
}
