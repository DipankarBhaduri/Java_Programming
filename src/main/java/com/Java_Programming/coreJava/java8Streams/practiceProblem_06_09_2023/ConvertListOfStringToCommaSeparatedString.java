package com.Java_Programming.coreJava.java8Streams.practiceProblem_06_09_2023;

import java.util.Arrays;
import java.util.List;

public class ConvertListOfStringToCommaSeparatedString {
    /**
     * @Questions Given a list of strings, concatenate them into a single comma-separated string
     *            using the Stream API.
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("I", "Am", "A", "Java", "Developer");
        String response = getListToStringWithCommaSeparated (list);
        System.out.println(response);
    }

    private static String getListToStringWithCommaSeparated(List<String> stringList) {
        return stringList.stream().reduce((s1, s2) -> s1.concat("-").concat(s2)).get();
    }
}
