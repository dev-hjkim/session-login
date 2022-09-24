package com.example.session.auth.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {
    private long memberNo;
    private String userId;
    private String password;
    private String name;
}
