package com.fizzbuzz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FizzBuzzRequest {
    private String text;

    public FizzBuzzRequest(String text) {
        this.text = text;
    }
}
