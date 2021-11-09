package com.fizzbuzz.converter;

import com.fizzbuzz.dto.FizzBuzzDto;
import com.fizzbuzz.entity.FizzBuzz;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzzToFizzBuzzDto implements Converter<FizzBuzz, FizzBuzzDto> {

    @Override
    public FizzBuzzDto convert(FizzBuzz fizzBuzz) {
        FizzBuzzDto fizzBuzzDto = new FizzBuzzDto();
        fizzBuzzDto.setId(fizzBuzz.getId());
        fizzBuzzDto.setCountFizz(fizzBuzz.getCountFizz());
        fizzBuzzDto.setCountBuzz(fizzBuzz.getCountBuzz());
        fizzBuzzDto.setCountFizzBuzz(fizzBuzz.getCountFizzBuzz());
        fizzBuzzDto.setText(fizzBuzz.getText());

        return fizzBuzzDto;
    }
}
