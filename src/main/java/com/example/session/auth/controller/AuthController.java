package com.example.session.auth.controller;

import com.example.session.auth.dto.LoginDto;
import com.example.session.auth.model.User;
import com.example.session.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public User login(@RequestBody LoginDto loginDto,
                      HttpServletRequest request) {

        User user = authService.getUser(loginDto);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return user;
    }
}
