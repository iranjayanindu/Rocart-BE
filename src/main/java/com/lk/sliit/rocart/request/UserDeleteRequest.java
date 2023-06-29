package com.lk.sliit.rocart.request;

import lombok.Data;

@Data
public class UserDeleteRequest {
    private String eMail;
    private String password;
}
