package com.example.session.exception;

import com.example.session.common.dto.ResultType;

public class UserNotFoundException extends BaseException {

    private static final long serialVersionUID = 4190794399670700323L;

    public UserNotFoundException() {
        super(ResultType.UNKNOWN_USER);
    }
}
