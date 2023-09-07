package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_06_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MakeSquareOfEachList {
    /**
     * @Questions : Given a list of integers, use the Stream API to
     *              find the square of each integer and collect the results into a new list
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2,4,6,8);
        integerList = getSquareNumbers (integerList);
        integerList.stream().forEach(System.out::println);
    }

    private static List<Integer> getSquareNumbers(List<Integer> integerList) {
        return integerList.stream().map( num -> num * num).collect(Collectors.toList());
    }
}
