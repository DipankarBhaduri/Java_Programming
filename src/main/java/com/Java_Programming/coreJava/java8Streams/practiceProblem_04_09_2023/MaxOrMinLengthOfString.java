package com.Java_Programming.coreJava.java8Streams.practiceProblem_04_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class MaxOrMinLengthOfString {
    /**
     * @Questions : Find the maximum and minimum lengths of strings in a list using Stream operations
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritam", "Shivam", "Ajay", "Abc");
        LongSummaryStatistics summaryStatistics = getMaxAndMinLengthOfString (stringList);
        System.out.println("Max - " +summaryStatistics.getMax());
        System.out.println("Min - " +summaryStatistics.getMin());
    }

    private static LongSummaryStatistics getMaxAndMinLengthOfString(List<String> stringList) {
        return stringList.stream().collect(Collectors.summarizingLong(String::length));
    }
}
