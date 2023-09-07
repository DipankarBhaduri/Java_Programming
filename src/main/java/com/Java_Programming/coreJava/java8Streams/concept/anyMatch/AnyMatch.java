package com.Java_Programming.coreJava.java8Streams.concept.anyMatch;

import java.util.Arrays;
import java.util.List;

public class AnyMatch {
    /**
     * @Questions : Given a list of exam scores, determine if any student has scored above a certain threshold
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(33, 22, 38, 49, 59, 77);
        Boolean status = checkAnyStudentGotMoreThan60 (scores);
        System.out.println(status);
    }

    private static Boolean checkAnyStudentGotMoreThan60(List<Integer> scores) {
        return scores.stream().anyMatch(s -> s > 60);
    }
}
