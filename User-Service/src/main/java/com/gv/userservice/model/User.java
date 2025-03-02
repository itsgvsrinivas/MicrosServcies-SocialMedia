package com.gv.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    Long userId;
    String name;
    String age;
    String mobileNumber;

    Post post;
    Notification notification;
}
