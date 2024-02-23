package com.ticketez.customerservice.exception;

public class CustomerInfoIsExistsException extends RuntimeException{

    public CustomerInfoIsExistsException (String message){
        super(message);
    }
}
