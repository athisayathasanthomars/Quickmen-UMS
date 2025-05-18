package com.thomarsthuvarangan.ums.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentsException.class)
    public ResponseEntity<String> handleNoStudentsFound(StudentsException except){
        return new ResponseEntity<>(except.getMessage(),HttpStatus.NOT_FOUND);
    }
}
