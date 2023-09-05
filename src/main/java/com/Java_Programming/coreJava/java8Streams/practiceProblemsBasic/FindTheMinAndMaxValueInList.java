package com.Java_Programming.coreJava.java8Streams.practiceProblemsBasic;

import java.util.Arrays;
import java.util.List;

public class FindTheMinAndMaxValueInList {
    /**
     * @Question1 Finding Minimum: Find the minimum value in a list of integers using min.
     * @Question2 Find the maximum value in a list of doubles using max.
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2,5,3,7,4,8,9,1);

        System.out.println("<-- ----------------- Find Min Value ---------------- -->");
        int minValue = findOutMinimumNumber (integerList);
        System.out.println(minValue);

        System.out.println("<-- ----------------- Find Max Value ---------------- -->");
        int maxValue = findOutMaximumNumber (integerList);
        System.out.println(maxValue);
    }

    private static int findOutMaximumNumber(List<Integer> integerList) {
        return integerList.stream().max((num1, num2) -> num1 > num2 ? 1 : -1).get();
    }

    private static int findOutMinimumNumber(List<Integer> integerList) {
        return integerList.stream().min((num1, num2)-> num1 > num2 ? 1 : -1).get();
    }
}
