package com.fizzbuzz.controller;

import com.fizzbuzz.exception.FizzBuzzException;
import com.fizzbuzz.service.FizzBuzzDetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FizzBuzzDetectorController {

    @Autowired
    private FizzBuzzDetectorService service;

    @PostMapping("/api")
    public String getOverlapping( @RequestParam String text) {
        if (text == null){
            throw new FizzBuzzException("text  may be not null");
        }
        int length = text.replace(" ", "").length();
        if (length < 7 || length > 100) {
            throw new FizzBuzzException("text length not valid may be (length>7 && length<100 )");
        }
        return service.getOverlapping(text);
    }
}
