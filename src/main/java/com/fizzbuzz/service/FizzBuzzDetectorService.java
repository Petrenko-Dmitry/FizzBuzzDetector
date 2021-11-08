package com.fizzbuzz.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzDetectorService {
    /*
     * Метод в котором мы находим и заменяем каждое 3-е слово на Fizz, каждое 5-ое на Buzz, и выводим строку с замененнными словами.
     * Так же подсчитываем количество произошедших замен.
     * */
    public String getOverlapping(String s) {
        String[] split = split(s);
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
        return builderToString(split).toString() + "\n" + "Fizz = " + countFizz + ", Buzz = " + countBuzz + ", FizzBuzz = " + countFizzBuzz;
    }

    /*
     * Метод в котором мы разбиваем строку на отдельные слова для подальшего использования в массиве.
     * */
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

    /*
     * Метод для вывода текста целой строкой.
     * */
    public static StringBuilder builderToString(String[] split) {
        StringBuilder builder = new StringBuilder();
        for (String word : split) {
            builder.append(word);
            builder.append(" ");
        }
        return builder;
    }
}
