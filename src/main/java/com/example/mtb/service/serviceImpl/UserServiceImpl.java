package com.example.mtb.service.serviceImpl;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.Role;
import com.example.mtb.exception.EmailAlreadyExistException;
import com.example.mtb.exception.EmailNotExistException;
import com.example.mtb.mapper.UserMapper;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.security.SecurityConfig;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

 // current time in milliseconds
    @Override
    public UserResponse userRegister(UserRegistrationRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistException("user mail already exist " + request.email());
        }

        if (request.role() == Role.USER) {
            User user = userMapper.toUser(request);
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            return userMapper.toResponse(userRepository.save(user));
        } else {
            TheaterOwner theaterOwner = userMapper.toTheaterOwner(request);
            String encodedPassword = passwordEncoder.encode(theaterOwner.getPassword());
            theaterOwner.setPassword(encodedPassword);
            return userMapper.toResponse(userRepository.save(theaterOwner));
        }
    }

    @Override
    public UserResponse updateUser(UserRequest request, String email) {
        UserDetails userDetails = userRepository.findByEmail(email);
        if (userDetails == null) {
            throw new EmailNotExistException("user mail not exist " + email);
        }else if (userDetails.isDelete()){
            throw new EmailNotExistException("User already deleted");
        }
        return userMapper.toResponse(userRepository.save(userMapper.toUpdateUserDetails(request, userDetails)));
    }

    @Override
    public UserResponse deleteUser(String email) {
        UserDetails userDetails = userRepository.findByEmail(email);
        if (userDetails == null) {
            throw new EmailNotExistException("user mail not exist " + email);
        }else if(userDetails.isDelete()){
            throw new EmailNotExistException("User already deleted");
        }
        return userMapper.toResponse(userRepository.save(userMapper.toDeleteUserDetails(userDetails)));
    }
}
