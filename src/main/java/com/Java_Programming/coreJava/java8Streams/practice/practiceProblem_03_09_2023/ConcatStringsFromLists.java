package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_03_09_2023;

import java.util.Arrays;
import java.util.List;

public class ConcatStringsFromLists {
    /**
     * @Question : Joining Strings: Given a list of words, join them into a single string with spaces in between.
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Mr", "Dipankar", "Bhaduri");
        String string = createStringByConcatingAllStringsFromList(list);
        System.out.println(string);
    }

    private static String createStringByConcatingAllStringsFromList(List<String> list) {
        return list.stream().reduce("", (s1, s2) -> s1.concat(" ").concat(s2)).substring(1);
    }
}
