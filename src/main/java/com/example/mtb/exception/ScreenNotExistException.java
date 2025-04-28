package com.example.mtb.exception;

public class ScreenNotExistException extends RuntimeException{
    private String message;

    public ScreenNotExistException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
