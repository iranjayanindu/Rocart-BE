package com.lk.sliit.rocart.service;



import com.lk.sliit.rocart.dto.UserDto;

import java.util.Optional;

public interface UserService {
    UserDto save(UserDto user) throws Exception;

    Optional<UserDto> findByEmail(String email);
}
