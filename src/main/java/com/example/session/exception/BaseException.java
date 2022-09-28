package com.example.session.exception;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -7627183204689684257L;

    public BaseException(String message) {
        super(message);
    }
}
