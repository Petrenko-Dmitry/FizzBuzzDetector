package com.fizzbuzz.service;

import com.fizzbuzz.converter.FizzBuzzToFizzBuzzDto;
import com.fizzbuzz.dto.FizzBuzzDto;
import com.fizzbuzz.dto.FizzBuzzResponse;
import com.fizzbuzz.entity.FizzBuzz;
import com.fizzbuzz.repository.FizzBuzzRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FizzBuzzDetectorService {
    private final FizzBuzzRepository fizzBuzzRepository;
    private final FizzBuzzToFizzBuzzDto fizzBuzzToFizzBuzzDto;

    public FizzBuzzDetectorService(FizzBuzzRepository fizzBuzzRepository, FizzBuzzToFizzBuzzDto fizzBuzzToFizzBuzzDto) {
        this.fizzBuzzRepository = fizzBuzzRepository;
        this.fizzBuzzToFizzBuzzDto = fizzBuzzToFizzBuzzDto;
    }

    /**
     * Метод в котором мы находим и заменяем каждое 3-е слово на Fizz, каждое 5-ое на Buzz, и выводим строку с замененными словами.
     * Так же подсчитываем количество произошедших замен.
     *
     * @param s - входящий текст, который разбивается по слову на массив String.
     *          Массив потом используется для замены слов по соответствующему алгоритму.
     * @return получаем сущность FizzBuzzResponse в которой записан уже изменённый текст, и присвоенный id, для сохранения.
     */
    public FizzBuzzResponse getOverlapping(String s) {
        String[] split = split(s);
        FizzBuzz fizzBuzz = new FizzBuzz();
        int countFizz = 0, countBuzz = 0, countFizzBuzz = 0;
        for (int i = 0; i < split.length; i++) {
            if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0) {
                split[i] = "FizzBuzz";
                countFizzBuzz++;
            } else if ((i + 1) % 3 == 0) {
                split[i] = "Fizz";
                countFizz++;
            } else if ((i + 1) % 5 == 0) {
                split[i] = "Buzz";
                countBuzz++;
            }
        }
        fizzBuzz.setText(builderToString(split).toString());
        fizzBuzz.setCountFizz(countFizz);
        fizzBuzz.setCountBuzz(countBuzz);
        fizzBuzz.setCountFizzBuzz(countFizzBuzz);
        Long savedId = fizzBuzzRepository.save(fizzBuzz).getId();
        return new FizzBuzzResponse(savedId, builderToString(split).toString());
    }

    /**
     * Метод в котором мы разбиваем строку на отдельные слова для подальшего использования в массиве.
     *
     * @param s - входящий текст который разбивается на массив String.
     * @return массив String.
     */
    public static String[] split(String s) {
        char[] ch = s.toCharArray();
        String sc = "";
        String[] split = new String[20];
        for (int i = 0, k = 0; i < ch.length; i++) {
            sc += ch[i];
            if (ch[i] == ' ' || (i + 1) == ch.length) {
                split[k] = sc;
                ++k;
                sc = "";
            }
        }
        return split;
    }

    /**
     * Метод для вывода текста целой строкой.
     *
     * @param split - массив с уже изменёнными словами
     * @return конечный результат работы алгоритма замены, в виде одной строки.
     */
    public static StringBuilder builderToString(String[] split) {
        StringBuilder builder = new StringBuilder();
        for (String word : split) {
            builder.append(word);
            builder.append(" ");
        }
        return builder;
    }

    /**
     * Метод для вывода всех результатов работы алгоритма.
     *
     * @return List<FizzBuzzDto> лист всех сохраненных ранее результатов.
     */
    public List<FizzBuzzDto> getAllFizzBuzz() {
        List<FizzBuzz> allFizzBuzz = fizzBuzzRepository.findAll();
        List<FizzBuzzDto> fizzBuzzDtoList = new ArrayList<>();
        for (FizzBuzz fizzBuzz : allFizzBuzz) {
            fizzBuzzDtoList.add(fizzBuzzToFizzBuzzDto.convert(fizzBuzz));
        }
        return fizzBuzzDtoList;
    }

    /**
     * Метод для поиска и вывода всех результатов работы алгоритма по количеству замены Buzz в строке.
     *
     * @param count - количество замены Buzz в строке по которому будет происходить поиск.
     * @return List<FizzBuzzDto> лист результатов поиска.
     */
    public List<FizzBuzzDto> getFizzBuzzByCount(Integer count) {
        List<FizzBuzz> fizzBuzzList = fizzBuzzRepository.findByCountBuzz(count);
        List<FizzBuzzDto> fizzBuzzDtoList = new ArrayList<>();
        for (FizzBuzz fizzBuzz : fizzBuzzList) {
            fizzBuzzDtoList.add(fizzBuzzToFizzBuzzDto.convert(fizzBuzz));
        }
        return fizzBuzzDtoList;
    }
}
