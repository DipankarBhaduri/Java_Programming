package com.Java_Programming.coreJava.java8Streams.practiceProblem_06_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteredStringByCharacter {
    /**
     * @Questions Given a list of strings, use the Stream API to filter out all strings that contain the letter 'a'.
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritm", "BBSR", "BCDE", "Palas");
        List<String> filteredString = filteredTheList(stringList);
        filteredString.stream().forEach(System.out::println);
    }

    private static List<String> filteredTheList(List<String> stringList) {
        return stringList.stream()
                .filter(s -> s.contains(String.valueOf('a')))
                .collect(Collectors.toList());
    }
}
