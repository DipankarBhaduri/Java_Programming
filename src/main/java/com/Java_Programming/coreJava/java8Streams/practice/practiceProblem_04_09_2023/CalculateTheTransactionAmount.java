package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_04_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class CalculateTheTransactionAmount {
    /**
     * @Questions : Given a list of sales transactions (with transaction amount),
     *              calculate the total sales using the summarizing operation
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(20, 30, 40, 50, 60);
        LongSummaryStatistics longSummaryStatistics = getTotalAmount (list);
        System.out.println(longSummaryStatistics.getSum());
    }

    private static LongSummaryStatistics getTotalAmount(List<Integer> list) {
        return  list.stream().collect(Collectors.summarizingLong(num -> num));
    }
}
