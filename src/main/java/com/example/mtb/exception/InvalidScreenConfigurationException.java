package com.example.mtb.exception;

public class InvalidScreenConfigurationException extends RuntimeException{
    private String message;

    public InvalidScreenConfigurationException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
