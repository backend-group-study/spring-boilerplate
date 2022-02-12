package com.study.spring.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Response<T> {

    private T data;
    private final String message;
    private final HttpStatus httpStatus;

    public Response(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Response(T data, String message, HttpStatus httpStatus) {
        this.data = data;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
