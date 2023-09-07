package com.Java_Programming.learning.coreJava.java8Streams.concept.flatMapToInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class FlatMapToInt {
    public static void main(String[] args) {
        List<Double> doubleList = Arrays.asList(2.6, 6.7, 6.5, 6.3, (double)6);
        List<Integer> integerList = convertDoubleToIntegerListUsingFlatMap (doubleList);

        integerList.stream().forEach(System.out::println);
    }

    private static List<Integer> convertDoubleToIntegerListUsingFlatMap(List<Double> doubleList) {
        return doubleList.stream()
                .flatMapToDouble( aDouble -> DoubleStream.of(aDouble))
                .mapToObj(d -> (int) d)
                .collect(Collectors.toList());
    }
}
