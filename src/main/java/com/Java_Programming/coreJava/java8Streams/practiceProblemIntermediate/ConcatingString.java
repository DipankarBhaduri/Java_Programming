package com.Java_Programming.coreJava.java8Streams.practiceProblemIntermediate;

import java.util.Arrays;
import java.util.List;

public class ConcatingString {
    /**
     * @Question : Create a Stream of strings and use the map operation
     *             to append " - Processed" to each string.
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Shivam", "Pritam", "Abc");
        List<String> response = getConcatedString (stringList);
        response.forEach(System.out::println);
    }

    private static List<String> getConcatedString(List<String> stringList) {
        return stringList.stream().map(s -> s.concat(" - Processed")).toList();
    }
}
