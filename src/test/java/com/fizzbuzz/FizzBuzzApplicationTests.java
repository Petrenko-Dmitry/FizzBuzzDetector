package com.fizzbuzz;

import com.fizzbuzz.controller.FizzBuzzDetectorController;
import com.fizzbuzz.exception.FizzBuzzException;
import com.fizzbuzz.service.FizzBuzzDetectorService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FizzBuzzApplicationTests {

    @Autowired
    private FizzBuzzDetectorService service;
    @Autowired
    private FizzBuzzDetectorController controller;

    @Test
    void split() {
        String text = "Mary had a little lamb " +
                "Little lamb, little lamb " +
                "Mary had a little lamb " +
                "It's fleece was white as snow";
        List<String> arrayString = List.of(text.split(" +"));
        Assert.isTrue(arrayString.size() == 20, "arrayString length may be 20");
    }

    @Test
    void negativeCheckNullTest() {
        String text = "Mary had a little lamb " +
                "Little lamb, little lamb " +
                "Mary had a little lamb " +
                "It's fleece was white as snow";
        Assert.isTrue(StringUtils.isNotBlank(text), "text not be Null");
    }

    @Test
    void textLengthTestError() {
        String text = "fgdsgggggggggggggggggggggggggggggggggggggggggggggggggggggg yyyyyyyyyyyyyy sssssssssssssss eeeeeeeeeeeeeeeeeee oooooooo aaaaaaaa";
        FizzBuzzException exception = assertThrows(FizzBuzzException.class, () -> {
            controller.getOverlapping(text);
        });
        String expectedMessage = "text length not valid may be (length>7 && length<100 )";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void textNullTestError() {
        FizzBuzzException exception = assertThrows(FizzBuzzException.class, () -> {
            controller.getOverlapping(null);
        });
        String expectedMessage = "text  may be not null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void positiveTest() {
        String text = "Mary had a little lamb " +
                "Little lamb, little lamb " +
                "Mary had a little lamb " +
                "It's fleece was white as snow";
        String result = service.getOverlapping(text);
        List<String> arrayString = List.of(result.split(" +"));
        Assert.isTrue(arrayString.size() > 0, "arrayString size > 0 ");
        Assert.isTrue(arrayString.get(2).equals("Fizz"), "may be Fizz");
        Assert.isTrue(arrayString.get(4).equals("Buzz"), "may be Buzz");
        Assert.isTrue(arrayString.get(14).equals("FizzBuzz"), "may be FizzBuzz");
    }

    @Test
    void countWorld() {
        String text = "Mary had a little lamb " +
                "Little lamb, little lamb " +
                "Mary had a little lamb " +
                "It's fleece was white as snow";
        String result = service.getOverlapping(text);
        List<String> arrayString = List.of(result.split(" +"));
        int fizz = Collections.frequency(arrayString, "Fizz");
        int buzz = Collections.frequency(arrayString, "Buzz");
        int fizzBuzz = Collections.frequency(arrayString, "FizzBuzz");
        Assert.isTrue(fizz == 5, "count world fizz = 5");
        Assert.isTrue(buzz == 3, "count world buzz = 3");
        Assert.isTrue(fizzBuzz == 1, "count world fizzBuzz = 1");

    }
}
