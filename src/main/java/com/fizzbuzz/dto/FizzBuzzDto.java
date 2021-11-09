package com.fizzbuzz.dto;

import lombok.Data;

@Data
public class FizzBuzzDto {
    private Long id;
    private String text;
    private Integer countFizz;
    private Integer countBuzz;
    private Integer countFizzBuzz;
}
