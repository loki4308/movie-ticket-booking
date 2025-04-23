package com.example.mtb.handler;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomFieldError {
    String field;
    Object rejectedValue;
    String errorMessage;
}
