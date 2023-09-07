package com.Java_Programming.coreJava.java8Streams.practiceProblem_04_09_2023;

import java.util.Arrays;
import java.util.List;

public class FindTheLongestWord {
    /**
     * @Question : Given a list of words, use Stream to find the longest word
     * @param args
     */
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Dipankar", "Pritam", "Shivam", "Ajay", "Abc");
        String longestString = findTheLongestString (nameList);
        System.out.println(longestString);
    }

    private static String findTheLongestString(List<String> nameList) {
       return nameList.stream().max((s1, s2) -> s1.length() > s2.length() ? 1 : -1).toString();
    }
}
