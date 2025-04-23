package com.example.mtb.handler;

import com.example.mtb.dto.UserResponse;
import com.example.mtb.utility.ResponseStructure;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        List<Map<String, String>> errors = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError fieldError) {
                Map<String, String> err = new HashMap<>();
                err.put("field", fieldError.getField());
                err.put("error", fieldError.getDefaultMessage());
                errors.add(err);
            } else {
                Map<String, String> err = new HashMap<>();
                err.put("field", "global");
                err.put("error", error.getDefaultMessage());
                errors.add(err);
            }
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
