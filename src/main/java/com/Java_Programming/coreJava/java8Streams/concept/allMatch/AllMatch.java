package com.Java_Programming.coreJava.java8Streams.concept.allMatch;

import java.util.Arrays;
import java.util.List;

public class AllMatch {
    /**
     * @Questions : Given a list of exam scores, determine if all student has scored above a certain threshold
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(76, 87, 78, 77);
        Boolean status = checkAnyStudentGotMoreThan60 (scores);
        System.out.println(status);
    }

    private static Boolean checkAnyStudentGotMoreThan60(List<Integer> scores) {
        return scores.stream().allMatch(s -> s > 60);
    }
}