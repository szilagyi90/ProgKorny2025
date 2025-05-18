package hu.szd.casinoalap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAllExceptions(Exception exception){
        return new ResponseEntity<>(new ApiError((HttpStatus.INTERNAL_SERVER_ERROR), exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
