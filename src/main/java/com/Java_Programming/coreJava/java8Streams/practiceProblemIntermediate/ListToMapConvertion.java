package com.Java_Programming.coreJava.java8Streams.practiceProblemIntermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapConvertion {
    /**
     * @Question : Given a list of names, use a Stream to create a HashMap where the keys are names,
     *             and the values are the lengths of the names
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritam", "Shivam", "Ajay", "Abc");
        Map<String, Integer> response = convertListToMap(stringList);
        response.entrySet().forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()+"-"+stringIntegerEntry.getValue()));
    }

    private static Map<String, Integer> convertListToMap(List<String> stringList) {
        return stringList.stream().collect(Collectors.toMap(
                Function.identity(),
                String::length));
    }
}
