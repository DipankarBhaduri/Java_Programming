package com.Java_Programming.coreJava.java8Streams.concept.findAny;

import java.util.Arrays;
import java.util.List;

public class FindAny {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("abc", "bcd", "cde", "def");
        String s = findAnyList (names);
        System.out.println(s);
    }

    private static String findAnyList(List<String> names) {
        return names.stream().filter(name -> name.contains("b")).findAny().get();
    }
}
