package com.fizzbuzz.exception;

import lombok.Data;

@Data
public class Error {
    private String message;
    private int code;

    public Error() {
    }

    public Error(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
