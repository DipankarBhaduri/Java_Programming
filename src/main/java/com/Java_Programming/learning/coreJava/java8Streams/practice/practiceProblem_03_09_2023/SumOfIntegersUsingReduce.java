package com.Java_Programming.learning.coreJava.java8Streams.practice.practiceProblem_03_09_2023;

import java.util.Arrays;
import java.util.List;

public class SumOfIntegersUsingReduce {
    /**
     * @Question Reducing: Calculate the sum of all integers in a list using reduce.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2,3,4,5,6,7,8,9,10);
        int sum = getSumOfAllIntegers (integerList);
        System.out.println(sum);
    }

    private static int getSumOfAllIntegers(List<Integer> integerList) {
        return integerList.stream().reduce(0, Integer::sum);
    }
}
