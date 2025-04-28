package com.example.mtb.mapper;

import com.example.mtb.dto.SeatResponse;
import com.example.mtb.entity.Screen;
import com.example.mtb.entity.Seat;
import com.example.mtb.entity.Theater;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatMapper {

    long now = System.currentTimeMillis();

    public List<Seat> toSeat(Screen screen){
        int capacity = screen.getCapacity();
        int noOfRows = screen.getNoOfRows();

        int seatsPerRow = capacity / noOfRows;
        List<Seat> seatList = new ArrayList<>();

        for(int row =0; row < noOfRows; row++){
            char rowChar = (char) ('A'+ row); //  'A'+row -> 'A'+0=A -> 'A'+1=B
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                Seat seat = new Seat();
                seat.setSeatName(rowChar + String.valueOf(seatNum));  // A+1=A1 -> A+2=A2
                seat.setCreatedAt(now);
                seat.setScreen(screen);
                seatList.add(seat);
            }
        }
        return seatList;
    }
    public List<SeatResponse> toSeatResponseList(List<Seat> seats){
        List<SeatResponse> seatResponseList = new ArrayList<>();
        for (Seat seat : seats){
            seatResponseList.add(SeatResponse.builder()
                    .seatId(seat.getSeatId())
                    .seatName(seat.getSeatName())
                    .build());
        }
        return seatResponseList;
    }

}
