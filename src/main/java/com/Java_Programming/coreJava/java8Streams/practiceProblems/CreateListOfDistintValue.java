package com.Java_Programming.coreJava.java8Streams.practiceProblems;

import java.util.Arrays;
import java.util.List;

public class CreateListOfDistintValue {
    /**
     * @Question : Distinct Values: Given a list of integers with duplicates,
     *             create a list containing only distinct values.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 5, 3, 6, 2);
        List<Integer> distintElements = findDistintELements (list);
        distintElements.stream().forEach(System.out::println);
    }

    private static List<Integer> findDistintELements(List<Integer> integerList) {
        return integerList.stream().distinct().toList();
    }
}
