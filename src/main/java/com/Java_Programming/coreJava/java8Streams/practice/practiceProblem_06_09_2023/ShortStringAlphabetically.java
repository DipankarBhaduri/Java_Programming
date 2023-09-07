package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_06_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShortStringAlphabetically {
    /**
     * @Questions : Given a list of names, use the Stream API to sort them alphabetically.
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritam", "Pradeep", "Akash");
        List<String> sortedString = sortStringAlphabettically (stringList);
        sortedString.stream().forEach(System.out::println);
    }

    private static List<String> sortStringAlphabettically(List<String> stringList) {
        return stringList.stream().sorted().collect(Collectors.toList());
    }

}
