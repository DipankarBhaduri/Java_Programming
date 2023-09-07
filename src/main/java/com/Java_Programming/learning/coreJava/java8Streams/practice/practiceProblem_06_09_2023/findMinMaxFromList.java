package com.Java_Programming.learning.coreJava.java8Streams.practice.practiceProblem_06_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class findMinMaxFromList {
    /**
     * @Questions Create a stream of integers and use the Stream API to find the maximum and minimum 
     *            values in the stream
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2,3,4,9,4,5,6,7,8);
        int maxValue = getMaxInteger(integerList);
        System.out.println("Max Value - "+ maxValue);

        int minValue = getMinInteger(integerList);
        System.out.println("Min Value - "+ minValue);
    }

    private static int getMaxInteger(List<Integer> integerList) {
        return integerList.stream().max((num1, num2) -> num1 > num2 ? 1 : -1).get();
    }

    private static int getMinInteger(List<Integer> integerList) {
        return integerList.stream().min((num1, num2) -> num1 > num2 ? 1 : -1).get();
    }
}
