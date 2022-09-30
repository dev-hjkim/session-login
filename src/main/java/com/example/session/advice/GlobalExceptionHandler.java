package com.example.session.advice;


import com.example.session.common.dto.ExceptionResult;
import com.example.session.common.dto.ResultType;
import com.example.session.exception.BaseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

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

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
                                                                   HttpHeaders headers, HttpStatus status,
                                                                   WebRequest request) {
        System.out.println(ex.getMessage());
        return new ResponseEntity<>(new ExceptionResult(ResultType.PAGE_NOT_FOUND),
                ResultType.PAGE_NOT_FOUND.getStatus());
    }

    // http method 잘못된 경우
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status,
                                                                         WebRequest request) {
        return new ResponseEntity<>(new ExceptionResult(ResultType.METHOD_NOT_ALLOWED),
                ResultType.METHOD_NOT_ALLOWED.getStatus());
    }

    // 필수 파라미터 아예 없을 때(파라미터 중 아무것도 전달하지 않음)
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        return new ResponseEntity<>(new ExceptionResult(ResultType.MISSING_PARAMETER),
                ResultType.MISSING_PARAMETER.getStatus());
    }

    // validation 조건 만족하지 못한 경우
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        return new ResponseEntity<>(new ExceptionResult(ResultType.INVALID_PARAMETER),
                ResultType.INVALID_PARAMETER.getStatus());
    }


}
