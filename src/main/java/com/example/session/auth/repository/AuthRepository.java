package com.example.session.auth.repository;

import com.example.session.auth.dto.LoginDto;
import com.example.session.auth.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthRepository {
    User getUser(LoginDto loginDto);
}
