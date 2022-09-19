package com.example.session.auth.service;

import com.example.session.auth.dto.LoginDto;
import com.example.session.auth.model.User;

public interface AuthService {
    User getUser(LoginDto dto);
}
