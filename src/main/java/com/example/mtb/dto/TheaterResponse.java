package com.example.mtb.dto;

import com.example.mtb.entity.TheaterOwner;
import lombok.Builder;

@Builder
public record TheaterResponse(
        String theaterId,
        String name,
        String address,
        String city,
        String landmark,
        String createdBy
) {
}
