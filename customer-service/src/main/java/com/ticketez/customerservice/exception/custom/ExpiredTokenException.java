package com.ticketez.customerservice.exception.custom;

public class ExpiredTokenException extends RuntimeException{

    public ExpiredTokenException (String message){
        super(message);
    }
}
