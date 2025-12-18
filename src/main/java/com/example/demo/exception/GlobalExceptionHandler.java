package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Logger for tracking exception details
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handle ResourceNotFoundException (Custom Exception)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException ex) {
        logger.error("Resource not found: ", ex);
        
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("status", "NOT_FOUND");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Handle MethodArgumentNotValidException (Validation Errors)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethod(MethodArgumentNotValidException ex) {
        logger.error("Validation failed: ", ex);
        
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );

        Map<String, String> response = new HashMap<>();
        response.put("error", "Validation Failed");
        response.put("details", errors.toString());  // You can customize the response format here

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Handle all other Exceptions (General fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        logger.error("An unexpected error occurred: ", ex);

        Map<String, String> response = new HashMap<>();
        response.put("error", "Internal Server Error");
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
