package com.fizzbuzz.controller;

import com.fizzbuzz.dto.FizzBuzzDto;
import com.fizzbuzz.dto.FizzBuzzRequest;
import com.fizzbuzz.dto.FizzBuzzResponse;
import com.fizzbuzz.exception.RequestException;
import com.fizzbuzz.service.FizzBuzzDetectorService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FizzBuzzDetectorController {

    @Autowired
    private FizzBuzzDetectorService service;

    @PostMapping("/api")
    public FizzBuzzResponse getOverlapping(@RequestBody FizzBuzzRequest request) {
        if (request == null || Strings.isNullOrEmpty(request.getText())) {
            throw new RequestException("text  may be not null");
        }
        int length = request.getText().replace(" ", "").length();
        if (length < 7 || length > 100) {
            throw new RequestException("text length not valid may be (length>7 && length<100 )");
        }
        return service.getOverlapping(request.getText());
    }

    @GetMapping("/getAllFizzBuzz")
    public List<FizzBuzzDto> getAllFizzBuzz() {
        return service.getAllFizzBuzz();
    }

    @GetMapping("/getFizzBuzzByCount")
    public List<FizzBuzzDto> getFizzBuzzByCount(Integer count) {
        return service.getFizzBuzzByCount(count);
    }
}
