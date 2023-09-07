package com.Java_Programming.learning.coreJava.java8Streams.concept.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritam", "Ajay", "Gourav");
        List<String> strings = getFilteredName (stringList);
        strings.stream().forEach(System.out::println);
    }

    private static List<String> getFilteredName(List<String> stringList) {
        return stringList.stream().filter(name -> name.length() > 5).collect(Collectors.toList());
    }
}
