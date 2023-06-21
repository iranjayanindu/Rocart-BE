package com.lk.sliit.rocart.service.impl;


import com.lk.sliit.rocart.dto.UserDto;
import com.lk.sliit.rocart.entity.User;
import com.lk.sliit.rocart.repository.UserRepository;
import com.lk.sliit.rocart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto save(UserDto user) throws Exception {
        try {
            User userModel = modelMapper.map(user, User.class);
            userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
            userModel.setCreateTime(LocalDateTime.now());
            userModel.setRole(user.getRole());
            User save = userRepository.save(userModel);
            return modelMapper.map(save, UserDto.class);
        } catch (Exception e) {
            log.error("Error user create : Error: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        Optional<User> byUsername = userRepository.findByEmail(email);

        return byUsername.map(user -> UserDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .createTime(user.getCreateTime())
                .role(user.getRole())
                .build());
    }
}
