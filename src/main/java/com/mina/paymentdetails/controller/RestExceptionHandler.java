package com.mina.paymentdetails.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.mina.paymentdetails.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class RestExceptionHandler {

  @ExceptionHandler(ReferenceNotFoundException.class)
  public ResponseEntity<ApiErrorResponse> handleReferenceNotFoundException(ReferenceNotFoundException e) {

    return ResponseEntity.status(NOT_FOUND).body(ApiErrorResponse.builder()
        .errorCode(NOT_FOUND.value())
        .description(e.getMessage())
        .build());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiErrorResponse> handleUnknownException(Exception e) {

    return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(ApiErrorResponse.builder()
        .errorCode(INTERNAL_SERVER_ERROR.value())
        .description(e.getMessage())
        .build());
  }
}
