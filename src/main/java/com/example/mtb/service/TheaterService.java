package com.example.mtb.service;

import com.example.mtb.dto.TheaterRequest;
import com.example.mtb.dto.TheaterResponse;
import com.example.mtb.repository.TheaterRepository;

public interface TheaterService {
    TheaterResponse createTheater(TheaterRequest request, String email);

    TheaterResponse findTheaterById(String theaterId);

    TheaterResponse updateTheaterById(TheaterRequest request, String id);
}
