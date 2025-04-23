package com.example.mtb.utility;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Builder
public class ResponseStructure<T> {
    private int statusCode;
    private String massage;
    private T data;
}
