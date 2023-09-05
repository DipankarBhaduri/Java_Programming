package com.Java_Programming.coreJava.java8Streams.practiceProblemIntermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOutEvenNumberThenSquare {
    /**
     * @Question : Given a list of integers, filter out even numbers and then square the remaining numbers.
     *             Write a Java Stream program to accomplish this task.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,3,4,5,6,7,11);
        List<Integer> oddSquareNumber = getOddNumbersSquare (list);
        oddSquareNumber.stream().forEach(System.out::println);
    }

    private static List<Integer> getOddNumbersSquare(List<Integer> integerList) {
        return integerList.stream()
                .filter(integer -> integer % 2 != 0)
                .map(integer -> integer * integer)
                .collect(Collectors.toList());
    }
}
