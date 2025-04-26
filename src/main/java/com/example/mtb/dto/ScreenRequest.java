package com.example.mtb.dto;

import com.example.mtb.enums.ScreenType;

public record ScreenRequest(
        ScreenType screenType,
        Integer capacity,
        Integer noOfRows

) {
}
