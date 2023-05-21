package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(22, 2, -4, 0, 4, 6, -1, 11);
        List<Integer> positive = numbers.stream()
                .filter(n -> n > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}