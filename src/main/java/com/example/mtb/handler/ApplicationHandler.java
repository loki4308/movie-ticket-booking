package com.example.mtb.handler;

import com.example.mtb.exception.*;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.StructureResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler<T> {
    @Autowired
    private StructureResponseBuilder structureResponseBuilder;

    @ExceptionHandler
    public ResponseEntity<ResponseStructure<T>> handleEmailAlreadyExistException(EmailAlreadyExistException ex){
        return structureResponseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage(), null);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseStructure<T>> handleEmailNotExistException(EmailNotExistException ex){
        return structureResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseStructure<T>> handleNotTheaterOwnerException(NotTheaterOwnerException ex){
        return structureResponseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage(), null);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseStructure<T>> handleTheaterNotExistException(TheaterNotExistException ex){
        return structureResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseStructure<T>> handleInvalidScreenConfigurationException(InvalidScreenConfigurationException ex){
        return structureResponseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage(), null);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseStructure<T>> handleScreenNotExistException(ScreenNotExistException ex){
        return structureResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }
}
