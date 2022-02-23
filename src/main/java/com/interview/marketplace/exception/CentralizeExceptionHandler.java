package com.interview.marketplace.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CentralizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidEntryException.class)
    public ResponseEntity<Object> handleInValidEntryException(InvalidEntryException ex, WebRequest webRequest) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "One of 'buyerId' or 'sellerId' is required for this operation");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
