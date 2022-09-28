package com.example.session.advice;


import com.example.session.common.dto.ExceptionResult;
import com.example.session.common.dto.ResultType;
import com.example.session.exception.BaseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // method 잘못된 경우
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ExceptionResult handleWrongMethod(HttpRequestMethodNotSupportedException ex) {
        return new ExceptionResult(ResultType.METHOD_NOT_ALLOWED);
    }

    // 필수 파라미터 아예 없을 때(파라미터 중 아무것도 전달하지 않음)
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ExceptionResult handleMissingGetReqParam(MissingServletRequestParameterException ex) {
        return new ExceptionResult(ResultType.MISSING_PARAMETER);
    }

    // validation 조건 만족하지 못한 경우
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ExceptionResult handleMissingPostReqParam(MethodArgumentNotValidException ex) {
        return new ExceptionResult(ResultType.INVALID_PARAMETER);
    }

    // DB: 중복 데이터
    @ExceptionHandler({DuplicateKeyException.class})
    public ExceptionResult handleDBDuplicateError(DuplicateKeyException ex) {
        return new ExceptionResult(ResultType.DATA_ALREADY_EXIST);
    }

    // DB: not-null 항목 안넣은 경우
    @ExceptionHandler({DataIntegrityViolationException.class})
    public ExceptionResult handleDBIntegrityError(DataIntegrityViolationException ex) {
        return new ExceptionResult(ResultType.NOT_ALLOWED_OPERATION);
    }

    @ExceptionHandler({BaseException.class})
    public ExceptionResult handleBaseException(BaseException ex) {
        return new ExceptionResult(ex.getResultType());
    }
}
