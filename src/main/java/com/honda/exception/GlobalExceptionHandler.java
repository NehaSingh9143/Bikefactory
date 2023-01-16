package com.honda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value
            = BikeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ResponseEntity<String>
    handleBikeException(BikeException ex) {
        return new ResponseEntity<>(
                ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value
            = CategoryException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ResponseEntity<String>
    handleCategoryException(CategoryException ex) {
        return new ResponseEntity<>(
                ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
