package com.example.mtb.service.serviceImpl;

import com.example.mtb.dto.ScreenRequest;
import com.example.mtb.dto.ScreenResponse;
import com.example.mtb.dto.SeatResponse;
import com.example.mtb.dto.TheaterRequest;
import com.example.mtb.entity.Screen;
import com.example.mtb.entity.Seat;
import com.example.mtb.entity.Theater;
import com.example.mtb.exception.InvalidScreenConfigurationException;
import com.example.mtb.exception.ScreenNotExistException;
import com.example.mtb.exception.TheaterNotExistException;
import com.example.mtb.mapper.ScreenMapper;
import com.example.mtb.mapper.SeatMapper;
import com.example.mtb.repository.ScreenRepository;
import com.example.mtb.repository.SeatRepository;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private TheaterRepository theaterRepository;
    private ScreenRepository screenRepository;
    private ScreenMapper screenMapper;
    private SeatRepository seatRepository;
    private SeatMapper seatMapper;

    @Override
    public ScreenResponse createScreen(ScreenRequest request, String theaterId) {

        if(request.capacity() < request.noOfRows()){
            throw new InvalidScreenConfigurationException("Capacity cannot be less than the number of rows.");
        }
        Theater theater = theaterRepository.findById(theaterId).orElseThrow(() -> new TheaterNotExistException("Theater not found"));
        Screen screen = screenMapper.toScreen(request, theater);
        List<Seat> seatlist = seatMapper.toSeat(screen);
        screen.setSeats(seatlist);
        Screen savedScreen = screenRepository.save(screen);
        List<SeatResponse> seatResponseList = seatMapper.toSeatResponseList(seatRepository.saveAll(seatlist));
        return screenMapper.toScreenResponse(savedScreen, seatResponseList);
    }

    @Override
    public ScreenResponse findByScreenId(String screenId) {
        Screen screen = screenRepository.findById(screenId).orElseThrow(()-> new ScreenNotExistException("Screen not exist"));
        List<SeatResponse> seatResponseList = seatMapper.toSeatResponseList(screen.getSeats());
        return screenMapper.toScreenResponse(screen, seatResponseList);
    }

    @Override
    public ScreenResponse updateScreenById(ScreenRequest request, String screenId) {
        Screen screen = screenRepository.findById(screenId).orElseThrow(()-> new ScreenNotExistException("Screen not exist"));
        Screen updatedScreen = screenMapper.toUpdateScreen(request, screen) ;
        return null;
    }
}
