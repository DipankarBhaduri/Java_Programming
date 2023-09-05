package com.Java_Programming.coreJava.java8Streams.practiceProblemsBasic;

import java.util.Arrays;
import java.util.List;

public class CombinedTwoListAndMakeSum {
    /**
     * @Question : Combining Lists: Given two lists of integers,
     *             combine them into a single list and calculate the sum of all integers.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2, 4, 6, 8);
        List<Integer> list2 = Arrays.asList(1, 3, 5, 7);

        int sum = combinedTwoListAndSum (list1, list2);
        System.out.println(sum);
    }

    private static int combinedTwoListAndSum(List<Integer> list1, List<Integer> list2) {
        int sum = list1.stream().reduce(1, Integer::sum);
        return sum + list2.stream().reduce(1, Integer::sum);
    }
}
