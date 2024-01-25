package com.example.demo.exceptions;


import com.example.demo.dto.ErrorDTO;
import com.example.demo.exceptions.custom.BadRequestException;
import com.example.demo.exceptions.custom.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleResourceNotFoundexception(ResourceNotFoundException example){
        ErrorDTO error = new ErrorDTO(example.getMessage() + "Error in finding bool in library", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<ErrorDTO> badRequestException(BadRequestException example){
        ErrorDTO error = new ErrorDTO(example.getMessage() + "Error in finding bool in library", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
