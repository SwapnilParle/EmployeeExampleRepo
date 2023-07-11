package com.dbConnection.DbConnection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException {
    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleIllegalStateException(IllegalStateException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ClassNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleClassNotFoundException(ClassNotFoundException ex) {
        return ex.getMessage();
    }
}
