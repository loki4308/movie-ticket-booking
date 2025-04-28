package com.example.mtb.dto;

import com.example.mtb.entity.Seat;
import com.example.mtb.enums.ScreenType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Builder
public record ScreenResponse(
        String screenId,
        ScreenType screenType,
        Integer capacity,
        Integer noOfRows,
        String createdBy,
        List<SeatResponse> seatResponse

) {
}
