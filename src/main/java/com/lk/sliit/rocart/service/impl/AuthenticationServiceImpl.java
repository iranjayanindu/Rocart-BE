package com.lk.sliit.rocart.service.impl;


import com.lk.sliit.rocart.config.UserPrincipal;
import com.lk.sliit.rocart.config.jwt.JwtProvider;
import com.lk.sliit.rocart.dto.UserDto;
import com.lk.sliit.rocart.entity.User;
import com.lk.sliit.rocart.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public UserDto signInAndReturnJWT(UserDto signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User user = userPrincipal.getUser();
        user.setToken(jwt);

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .createTime(user.getCreateTime())
                .role(user.getRole())
                .token(user.getToken())
                .build();
    }

}
