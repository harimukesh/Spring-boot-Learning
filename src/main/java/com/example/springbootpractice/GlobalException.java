package com.example.springbootpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ExceptionHandle.CustomException.class)
    public ResponseEntity<?> handleException(ExceptionHandle.CustomException ex){
        return new ResponseEntity<>(ex.getMessage() , ex.getStatus());
    }
}
