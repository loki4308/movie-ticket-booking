package com.example.mtb.mapper;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    long now = System.currentTimeMillis();

    public UserResponse toResponse(UserDetails user){
        return new UserResponse(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getRole(),
                user.getPhoneNumber(),
                user.getDateOfBirth()
        );
    }

    public User toUser(UserRegistrationRequest request){
        User user = new User();
//        user.setUserId(user.getUserId());
        user.setUserName(request.userName());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setRole(request.role());
        user.setPhoneNumber(request.phoneNumber());
        user.setDateOfBirth(request.dateOfBirth());
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        return user;
    }

    public TheaterOwner toTheaterOwner(UserRegistrationRequest request){
        TheaterOwner theaterOwner = new TheaterOwner();
//        theaterOwner.setUserId(theaterOwner.getUserId());
        theaterOwner.setUserName(request.userName());
        theaterOwner.setEmail(request.email());
        theaterOwner.setPassword(request.password());
        theaterOwner.setRole(request.role());
        theaterOwner.setPhoneNumber(request.phoneNumber());
        theaterOwner.setDateOfBirth(request.dateOfBirth());
        theaterOwner.setCreatedAt(now);
        theaterOwner.setUpdatedAt(now);
        return theaterOwner;
    }

    public UserDetails toUpdateUserDetails(UserRequest request, UserDetails userDetails){

        userDetails.setUserName(request.userName());
        userDetails.setPhoneNumber(request.phoneNumber());
        userDetails.setDateOfBirth(request.dateOfBirth());
        userDetails.setUpdatedAt(now);
        return userDetails;
    }

    public UserDetails toDeleteUserDetails(UserDetails userDetails){
        userDetails.setDeleteAt(now);
        userDetails.setDelete(true);
        return userDetails;
    }




//    public User setUser(UserRequest request, UserDetails userDetails){
//
//        userDetails.setUserName(request.userName());
//        userDetails.setPhoneNumber(request.phoneNumber());
//        userDetails.setDateOfBirth(request.dateOfBirth());
//        userDetails.setUpdatedAt(now);
//        return (User) userDetails;
//    }
//
//    public TheaterOwner setTheaterOwner(UserRequest request, UserDetails userDetails){
//
//        userDetails.setUserName(request.userName());
//        userDetails.setPhoneNumber(request.phoneNumber());
//        userDetails.setDateOfBirth(request.dateOfBirth());
//        userDetails.setUpdatedAt(now);
//        return (TheaterOwner) userDetails;
//    }
}
