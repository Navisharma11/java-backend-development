package com.navisharma.TouristManagementAPIGlobalExceptionHandling.advice;

import com.navisharma.TouristManagementAPIGlobalExceptionHandling.exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TouristControllerAdvice
{
    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTouristException(TouristNotFoundException tfn)
    {
        ErrorDetails error = new ErrorDetails("404 not found", tfn.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception e)
    {
        ErrorDetails error = new ErrorDetails("Internal Server Error", e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
