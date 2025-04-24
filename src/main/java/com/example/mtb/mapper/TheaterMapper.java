package com.example.mtb.mapper;

import com.example.mtb.dto.TheaterRequest;
import com.example.mtb.dto.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import org.springframework.stereotype.Component;

@Component
public class TheaterMapper {

    long now = System.currentTimeMillis();

    public TheaterResponse toTheaterResponse(Theater saved){

        return TheaterResponse.builder()
                .theaterId(saved.getTheaterId())
                .name(saved.getName())
                .address(saved.getAddress())
                .city(saved.getCity())
                .landmark(saved.getLandmark())
                .createdBy(saved.getCreatedBy())
                .build();
    }

    public Theater toTheater(TheaterRequest request, String email, TheaterOwner owner){
        return Theater.builder()
                .name(request.name())
                .address(request.address())
                .city(request.city())
                .landmark(request.landmark())
                .createdAt(now)
                .updateAt(now)
                .createdBy(email)
                .theaterOwner(owner)
                .build();
    }

    public Theater toUpdateTheater(TheaterRequest request, Theater theater) {
        theater.setName(request.name());
        theater.setAddress(request.address());
        theater.setCity(request.city());
        theater.setLandmark(request.landmark());
        theater.setUpdateAt(now);
        return theater;
    }
}
