package com.Java_Programming.learning.coreJava.java8Streams.practice.practiceProblem_06_09_2023;

import java.util.Arrays;
import java.util.List;

public class CheckAllNumberAreEven {
    /**
     * @Questions : Create a stream of numbers and use the Stream API to check if all elements are even
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2, 4, 6, 8, 10);
        Boolean ans = checkAllIntegersAreEvenAreNot (integerList);
        System.out.println(ans);
    }

    private static Boolean checkAllIntegersAreEvenAreNot(List<Integer> integerList) {
        return integerList.stream().filter(num1 -> num1 % 2 == 0).count() == integerList.size();
    }
}
