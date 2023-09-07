package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_04_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndMapStrings {
    /**
     * Quuestions : Problem 1: Filter and Map Strings You have a list of strings,
     *              and you want to filter out strings that contain the letter 'a',
     *              and then transform the remaining strings to uppercase. Write a Java Stream program to achieve this
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritam", "Ajay", "bcd", "mmdccd", "mehesh");
        List<String> upperCaseStringList = getFilteredList (stringList);
        System.out.println(upperCaseStringList);
    }

    private static List<String> getFilteredList(List<String> stringList) {
        return stringList.stream().filter(s-> !s.contains(String.valueOf('a'))).map(String::toUpperCase).collect(Collectors.toList());
    }
}
