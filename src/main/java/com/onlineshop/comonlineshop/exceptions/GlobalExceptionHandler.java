package com.onlineshop.comonlineshop.exceptions;

import com.onlineshop.comonlineshop.utils.ApiResponse;
import com.onlineshop.comonlineshop.utils.UtilsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // reprezinta (catch-ul) de la try
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return UtilsResponse.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handleBadRequestException(BadRequestException ex) {
        return UtilsResponse.error(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception ex) {
        return UtilsResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()); // 500
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return UtilsResponse.error(HttpStatus.BAD_REQUEST, ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
