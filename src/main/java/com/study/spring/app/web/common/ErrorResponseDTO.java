package com.study.spring.app.web.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseDTO {

    private final String message;
    private final HttpStatus httpstatus;
    private final List<String> errorDetails;

    @Builder
    public ErrorResponseDTO(String message, HttpStatus httpStatus, List<String> errorDetails) {
        this.message = message;
        this.httpstatus = httpStatus;
        this.errorDetails = errorDetails;
    }

}
