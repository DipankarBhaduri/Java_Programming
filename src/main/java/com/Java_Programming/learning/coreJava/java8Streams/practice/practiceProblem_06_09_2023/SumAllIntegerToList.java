package com.Java_Programming.learning.coreJava.java8Streams.practice.practiceProblem_06_09_2023;

import java.util.Arrays;
import java.util.List;

public class SumAllIntegerToList {
    /**
     * @Questions Write a Java program to create a list of integers and use the Stream API to find
     *            the sum of all the elements in the list.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4);
        int sum = getSumValueOFAllElement (list);
        System.out.println(sum);
    }

    private static int getSumValueOFAllElement(List<Integer> integerList) {
        return integerList.stream().reduce(0,(num1, num2) -> num1 + num2);
    }
}
