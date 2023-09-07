package com.Java_Programming.coreJava.java8Streams.concept.distinct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Distinct {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc", "abc", "bbd", "aac", "abc", "bcd");
        List<String> distinctList = getDistinctStringList (stringList);
        distinctList.stream().forEach(System.out::println);
    }

    private static List<String> getDistinctStringList(List<String> stringList) {
        return stringList.stream().distinct().collect(Collectors.toList());
    }
}
