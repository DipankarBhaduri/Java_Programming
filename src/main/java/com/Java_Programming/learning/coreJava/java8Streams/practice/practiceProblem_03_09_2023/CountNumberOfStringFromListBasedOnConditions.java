package com.Java_Programming.learning.coreJava.java8Streams.practice.practiceProblem_03_09_2023;

import java.util.Arrays;
import java.util.List;

public class CountNumberOfStringFromListBasedOnConditions {
    /**
     * @Questions Count the number of strings in a list that have more than 5 characters
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritam", "Ajay", "Shivam");
        int count = getListOfStringMoreThen5Length (stringList);
        System.out.println(count);
    }

    private static int getListOfStringMoreThen5Length(List<String> stringList) {
        return (int) stringList.stream().filter(s -> s.length() > 5).count();
    }
}
