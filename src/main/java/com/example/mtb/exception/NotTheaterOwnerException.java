package com.example.mtb.exception;

public class NotTheaterOwnerException extends RuntimeException{
    private String message;

    public NotTheaterOwnerException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
