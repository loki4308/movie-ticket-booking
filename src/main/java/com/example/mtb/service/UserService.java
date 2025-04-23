package com.example.mtb.service;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.mapper.UserMapper;


public interface UserService {
    public UserResponse userRegister(UserRegistrationRequest userDetails);

    public UserResponse updateUser(UserRequest request, String email);

    public UserResponse deleteUser(String email);
}
