package com.example.mtb.mapper;

import com.example.mtb.dto.ScreenRequest;
import com.example.mtb.dto.ScreenResponse;
import com.example.mtb.dto.SeatResponse;
import com.example.mtb.entity.Screen;
import com.example.mtb.entity.Theater;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScreenMapper {

    long now = System.currentTimeMillis();

    public ScreenResponse toScreenResponse(Screen screen, List<SeatResponse> seatResponseList){
        return ScreenResponse.builder()
                .screenId(screen.getScreenId())
                .screenType(screen.getScreenType())
                .capacity(screen.getCapacity())
                .noOfRows(screen.getNoOfRows())
                .createdBy(screen.getCreatedBy())
                .seatResponse(seatResponseList)
                .build();

    }

    public Screen toScreen(ScreenRequest request, Theater theater) {
        return Screen.builder()
                .screenType(request.screenType())
                .capacity(request.capacity())
                .noOfRows(request.noOfRows())
                .createdAt(now)
                .updatedAt(now)
                .createdBy(theater.getCreatedBy())
                .theater(theater)
                .build();
    }


}
