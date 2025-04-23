package com.example.mtb.dto;

import com.example.mtb.enums.Role;
import lombok.Getter;

import java.time.LocalDate;


public record UserRequest(
        String userName,
//        String email,
//        Role role,
        String phoneNumber,
        LocalDate dateOfBirth
) {

}
