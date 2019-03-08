package com.geekbrains.springthymeleafeboot.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponce> handleAllExeption(Exception exc) {
        ProductErrorResponce productErrorResponce = new ProductErrorResponce();
        productErrorResponce.setStatus(HttpStatus.BAD_REQUEST.value());
        productErrorResponce.setMessage(exc.getMessage());
        productErrorResponce.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(productErrorResponce, HttpStatus.BAD_REQUEST);
    }
}
