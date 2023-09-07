package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_04_09_2023;

import java.util.Arrays;
import java.util.List;

public class CalculateTheSumOfWithOutFiltered {
    /**
     * @Questions : Given a list of integers, use a Stream to filter out all even numbers,
     *              then calculate the sum of the remaining odd numbers
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2, 4, 6, 3, 5, 1, 9, 4);
        int sumOfOdd = getAllOddNumbersSum (integerList);
        System.out.println(sumOfOdd);
    }

    private static int getAllOddNumbersSum(List<Integer> integerList) {
        return integerList.stream()
                .filter(integer -> integer % 2 != 0)
                .reduce(0,Integer::sum);
    }
}
