package com.lk.sliit.rocart.request;

import lombok.Data;

@Data
public class UserUpdateNotificationPermissionRequest {

    private int userId;

    private boolean permission;
}
