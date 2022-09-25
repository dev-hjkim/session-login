package com.example.session.auth.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String id;
    private String password;
}
