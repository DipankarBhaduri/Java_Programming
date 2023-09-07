package com.Java_Programming.coreJava.java8Streams.concept.concat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Concat {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("I", "AM", "A", "JAVA", "DEVELOPER");
        String concatedString = getConcatedStringFromList (stringList);
        System.out.println(concatedString);
    }

    private static String getConcatedStringFromList(List<String> stringList) {
        return (String) stringList.stream().reduce((s1, s2) -> s1.concat("_").concat(s2)).orElse("");
    }
}
