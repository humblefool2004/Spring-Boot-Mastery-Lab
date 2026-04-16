package com.Week02Codes.SpringBootWebApplication.advices;

import com.Week02Codes.SpringBootWebApplication.exceptions.ResourceNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException exception) {
        ApiError apiError= ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
        return buildResponseErrorEntity(apiError);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationErrors(MethodArgumentNotValidException exception) {
        Map<String, List<String>> errors = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                ));
        ApiError apiError= ApiError.builder().status(HttpStatus.BAD_REQUEST).message("Input Validation Failed").subErrors(errors).build();
        return buildResponseErrorEntity(apiError);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception) {
        ApiError apiError= ApiError.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(exception.getMessage()).build();
        return buildResponseErrorEntity(apiError);
    }
    private ResponseEntity<ApiResponse<?>> buildResponseErrorEntity(ApiError apiError) {
        return new ResponseEntity<>(new  ApiResponse<>(apiError), apiError.getStatus());
    }


}
