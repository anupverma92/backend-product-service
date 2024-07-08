package com.anup.productmanagement.exception;

import com.anup.productmanagement.model.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class BackendProductServiceExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> generalException(Exception exception) {
        log.error(String.valueOf(exception));
        ExceptionResponse exResponse = ExceptionResponse.builder()
                .type("Exception")
                .detail(exception.getMessage())
                .errorCode(exception.getLocalizedMessage())
                .error("Exception")
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponse);
    }
}
