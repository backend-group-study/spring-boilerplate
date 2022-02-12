package com.study.spring.app.web.common;

import com.study.spring.exception.common.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(BizException.class)
    public ResponseEntity<ErrorResponseDTO> catchBizException(BizException e) {
        return generatorErrorResponse(e.getHttpStatus(), e);
    }


    public static ResponseEntity<ErrorResponseDTO> generatorErrorResponse(HttpStatus httpStatus, Exception e) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .message(e.getMessage())
                .httpStatus(httpStatus)
                .build();
        log.info(errorResponseDTO.toString());
        return new ResponseEntity<>(errorResponseDTO, httpStatus);
    }

}
