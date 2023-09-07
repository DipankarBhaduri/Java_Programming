package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_03_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOutEvenNumbers {
    /**
     * @Question Filtering : Given a list of integers, filter out all even numbers.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2,3,4,3,5,6,4,7,8,5);
        List<Integer> evenNumbers = getAllEvenNumbers(integerList);
        evenNumbers.stream().forEach(System.out::println);
    }
    public static List<Integer> getAllEvenNumbers (List<Integer> integerList) {
        return integerList
                .stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
    }
}
