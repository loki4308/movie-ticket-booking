package com.example.mtb.dto;

import com.example.mtb.enums.Role;

import java.time.LocalDate;

public record UserResponse(
        String userId,
        String userName,
        String email,
        Role role,
        String phoneNumber,
        LocalDate dateOfBirth
) {
}
