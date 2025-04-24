package com.example.mtb.utility;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorStructure<T> {
    private int errorCode;
    private String errorMessage;
    private T error;
}
