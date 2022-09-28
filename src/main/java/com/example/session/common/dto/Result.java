package com.example.session.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
public class Result {
    private ResultType resultType;

    @JsonIgnore
    private HttpStatus status;

    private String code;
    private String message;
    private Object data;

    public Result(ResultType resultType) {
        this.resultType = resultType;
    }

    public Result(Object data) {
        this.resultType = ResultType.OK;
        this.data = data;
    }

    public HttpStatus getStatus() {
        return this.resultType.getStatus();
    }
}
