package com.fizzbuzz.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = RequestException.class)
    public ResponseEntity<Error> requestError(RequestException e) {
        return new ResponseEntity<>(createError(e, 400), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = FizzBuzzException.class)
    public ResponseEntity<Error> fizzBuzzError(FizzBuzzException e) {
        return new ResponseEntity<>(createError(e, 422), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseEntity<Error> exception(Exception e) {
        return new ResponseEntity<>(createError(e, 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Error createError(Exception e, int codeError) {
        Error error = new Error();
        error.setCode(codeError);
        error.setMessage(e.getMessage());
        return error;
    }
}
