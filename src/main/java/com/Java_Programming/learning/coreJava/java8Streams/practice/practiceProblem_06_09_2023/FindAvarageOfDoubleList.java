package com.Java_Programming.learning.coreJava.java8Streams.practice.practiceProblem_06_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAvarageOfDoubleList {
    /**
     * @Questions Use the Stream API to find the average of a list of doubles.
     * @param args
     */
    public static void main(String[] args) {
        List<Double> doubleList = Arrays.asList(2.456, 5.645, 3.995);
        Double ans = getAverage(doubleList);
        System.out.println(ans);
    }

    private static Double getAverage(List<Double> doubleList) {
        return doubleList.stream()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();
    }
}
