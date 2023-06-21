package com.lk.sliit.rocart.service;


import com.lk.sliit.rocart.dto.UserDto;

public interface AuthenticationService {
    UserDto signInAndReturnJWT(UserDto signInRequest);
}
