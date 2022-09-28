package com.example.session.exception;

import com.example.session.common.dto.ResultType;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -7627183204689684257L;

    private ResultType resultType;

    public BaseException(ResultType resultType) {
        super(resultType.getMessage());
        this.resultType = resultType;
    }
}
