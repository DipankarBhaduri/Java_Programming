package com.Java_Programming.coreJava.java8Streams.concept.flatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritam", "Ajay", "Gourav");
        List<Character> strings = getCharactersAsList (stringList);
        strings.stream().forEach(System.out::println);
    }

    private static List<Character> getCharactersAsList(List<String> stringList) {
        return stringList.stream().flatMap(string -> Stream.of(string.charAt(1))).collect(Collectors.toList());
    }
}
