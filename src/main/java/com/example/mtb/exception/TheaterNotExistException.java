package com.example.mtb.exception;

public class TheaterNotExistException extends RuntimeException{
    private String message;

    public TheaterNotExistException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
