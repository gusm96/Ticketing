package com.ticketez.customerservice.domain.customer;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginReqDto {

    @NotBlank(message = "")
    @Size(min = 8, max = 16, message = "")
    private String username;
    @NotBlank(message = "")
    @Size(min = 8, max = 16, message = "")
    private String password;

}
