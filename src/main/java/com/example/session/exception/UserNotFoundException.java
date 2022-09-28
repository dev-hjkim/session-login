package com.example.session.exception;

public class UserNotFoundException extends BaseException {

    private static final long serialVersionUID = 4190794399670700323L;

    public UserNotFoundException() {
        super("유저를 찾을 수 없습니다.");
    }
}
