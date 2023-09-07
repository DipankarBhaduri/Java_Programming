package com.Java_Programming.learning.coreJava.java8Streams.concept.collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect {
    /**
     * @Questions : Given a list of exam scores, determine if all student has scored above a certain threshold
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(76, 87, 78, 77);
        List<Integer> list = doubleAllTheElement (scores);
        list.stream().forEach(System.out::println);
    }

    private static List<Integer> doubleAllTheElement(List<Integer> scores) {
        return scores.stream().map(score -> score * 2).collect(Collectors.toList());
    }
}
