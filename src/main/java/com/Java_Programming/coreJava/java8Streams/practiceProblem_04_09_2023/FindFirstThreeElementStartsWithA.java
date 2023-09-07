package com.Java_Programming.coreJava.java8Streams.practiceProblem_04_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindFirstThreeElementStartsWithA {
    /**
     * @Question : Use Stream to find the first three elements in a list that start with
     *             the letter "A."
     * @param args
     */
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("ABC", "ACD", "BBD", "CCA", "BCD", "AAA", "ABZ");
        List<String> filteredList = getFilteredNameList (nameList);
        filteredList.stream().forEach(System.out::println);
    }

    private static List<String> getFilteredNameList(List<String> nameList) {
        return nameList.stream()
                .filter(s -> s.startsWith("A"))
                .limit(3)
                .collect(Collectors.toList());
    }
}
