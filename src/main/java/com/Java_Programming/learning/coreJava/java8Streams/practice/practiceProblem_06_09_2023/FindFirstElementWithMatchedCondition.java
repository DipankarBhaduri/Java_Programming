package com.Java_Programming.learning.coreJava.java8Streams.practice.practiceProblem_06_09_2023;

import java.util.Arrays;
import java.util.List;

public class FindFirstElementWithMatchedCondition {
    /**
     * @Questions : Write a program to find the first element that matches a certain condition in a stream of strings.
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritam", "AAABBBCCC","ABC");
        String response = getFirstStringBasedOnTheCondition (stringList);
        System.out.println(response);
    }

    private static String getFirstStringBasedOnTheCondition(List<String> stringList) {
        return stringList.stream()
                .filter(s -> s.contains(String.valueOf('A')))
                .filter(s2 -> s2.length() > 2)
                .map(s3 -> s3.toUpperCase())
                .findFirst().get();
    }
}
