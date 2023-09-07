package com.Java_Programming.learning.coreJava.java8Streams.concept.flatMapToDouble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

public class FlatMapToDouble {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("24", "54", "55", "76");
        List<Double> doubleList = convertIntegerToDouble (stringList);

        doubleList.stream().forEach(System.out::println);
    }

    private static List<Double> convertIntegerToDouble(List<String> stringList) {
        List<Double> doubleList = new ArrayList<>();
        try{
            stringList.stream().flatMapToDouble(str -> DoubleStream.of(Double.parseDouble(str))).forEach( num1 -> {
                doubleList.add(num1);
            });
            return doubleList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return doubleList;
    }
}
