package com.fizzbuzz.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class FizzBuzz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Integer countFizz;
    private Integer countBuzz;
    private Integer countFizzBuzz;
}
