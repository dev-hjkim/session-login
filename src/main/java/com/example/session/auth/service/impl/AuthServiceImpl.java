package com.example.session.auth.service.impl;

import com.example.session.auth.repository.AuthRepository;
import com.example.session.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;
}
