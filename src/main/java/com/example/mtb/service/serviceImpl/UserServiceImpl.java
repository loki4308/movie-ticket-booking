package com.example.mtb.serviceImpl;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.Role;
import com.example.mtb.exception.EmailAlreadyExistException;
import com.example.mtb.mapper.UserMapper;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserResponse userRegister(UserRegistrationRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistException("user mail already exist " + request.email());
        }
        long now = System.currentTimeMillis(); // current time in milliseconds

        if (request.role() == Role.USER) {
            User user = UserMapper.craeteUser(request);
            user.setCreatedAt(now);
            user.setUpdatedAt(now);
            return new UserMapper().toResponse(userRepository.save(user));
        } else {
            TheaterOwner theaterOwner = UserMapper.craeteTheaterOwner(request);
            theaterOwner.setCreatedAt(now);
            theaterOwner.setUpdatedAt(now);
            return new UserMapper().toResponse(userRepository.save(theaterOwner));
        }

    }
}
