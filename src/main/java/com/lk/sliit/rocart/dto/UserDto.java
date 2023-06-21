package com.lk.sliit.rocart.dto;


import com.lk.sliit.rocart.enumz.Role;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private LocalDateTime createTime;
    private Role role;

    private String token;
}
