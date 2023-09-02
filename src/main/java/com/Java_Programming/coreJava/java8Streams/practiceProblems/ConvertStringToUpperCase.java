package com.Java_Programming.coreJava.java8Streams.practiceProblems;

import java.util.Arrays;
import java.util.List;

public class ConvertStringToUpperCase {
    /**
     * @Question Mapping: Given a list of strings, convert all strings to uppercase using map.
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritam", "Akash", "shivam");
        List<String> upperCaseStringList = convertToUpperCase (stringList);
        upperCaseStringList.stream().forEach(System.out::println);
    }

    private static List<String> convertToUpperCase(List<String> stringList) {
        return stringList.stream().map(s -> s.toUpperCase()).toList();
    }
}
