package com.Java_Programming.coreJava.java8Streams.concept.findFirst;

import java.util.Arrays;
import java.util.List;

public class FIndFirst {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("abc1", "bcd2", "cde", "def");
        String s = findFirstFromList (names);
        System.out.println(s);
    }

    private static String findFirstFromList(List<String> names) {
        return names.stream().filter( name -> name.contains("bc")).findFirst().get();
    }
}
