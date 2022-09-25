package com.example.session.auth.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class User {
    private long memberNo;
    private String userId;
    private String password;
    private Date regDt;
    private Date updDt;
}
