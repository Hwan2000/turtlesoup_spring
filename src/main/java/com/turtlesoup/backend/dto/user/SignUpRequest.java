package com.turtlesoup.backend.dto.user;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String password;
    private String passwordCheck;
    private String name;
}
