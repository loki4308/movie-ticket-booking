package com.example.mtb.service.serviceImpl;

import com.example.mtb.dto.TheaterRequest;
import com.example.mtb.dto.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.exception.EmailNotExistException;
import com.example.mtb.exception.NotTheaterOwnerException;
import com.example.mtb.exception.TheaterNotExistException;
import com.example.mtb.mapper.TheaterMapper;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final UserRepository userRepository;
    private final TheaterMapper theaterMapper;

    @Override
    public TheaterResponse createTheater(TheaterRequest request, String email) {
        UserDetails userDetails = userRepository.findByEmail(email);
        if(userDetails == null || userDetails.isDelete()){
            throw new EmailNotExistException("Email not found");
        }
        if(!(userDetails instanceof TheaterOwner)){
            throw new NotTheaterOwnerException("User is not a theater owner");
        }
        TheaterOwner owner = (TheaterOwner) userDetails;
        return theaterMapper
                .toTheaterResponse(theaterRepository.save(theaterMapper.toTheater(request, email, owner)));
    }

    @Override
    public TheaterResponse findTheaterById(String id) {
        Theater theater = theaterRepository.findById(id).orElseThrow(()-> new TheaterNotExistException("Theater not exist"));
        return theaterMapper.toTheaterResponse(theater);
    }

    @Override
    public TheaterResponse updateTheaterById(TheaterRequest request, String id) {
        Theater theater = theaterRepository.findById(id).orElseThrow(()-> new TheaterNotExistException("Theater not exist"));
        return theaterMapper.toTheaterResponse(theaterRepository.save(theaterMapper.toUpdateTheater(request, theater)));

    }
}
