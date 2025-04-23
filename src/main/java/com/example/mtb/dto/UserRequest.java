package com.example.mtb.dto;

import com.example.mtb.enums.Role;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDate;


public record UserRequest(

        @NotNull(message = "Username cannot be null")
        @NotBlank(message = "Username is mandatory")
        @Size(min = 3, max = 20, message = "Username must be 3 to 20 characters long")
        String userName,

        @NotNull(message = "Phone number is required")
        @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be a valid 10-digit Indian number")
        String phoneNumber,

        @NotNull(message = "Date of Birth is required")
        @Past(message = "Date of Birth must be in the past")
        LocalDate dateOfBirth
) {

}
