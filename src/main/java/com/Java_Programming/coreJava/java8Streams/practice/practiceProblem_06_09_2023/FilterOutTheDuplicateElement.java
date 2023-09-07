package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_06_09_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FilterOutTheDuplicateElement {
    /**
     * @Questions Use the Stream API to filter out duplicate elements from a list.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2, 3, 4, 6, 5, 2, 4);
        List<Integer> duplicateList = getDuplicateIntegersList (integerList);
        duplicateList.stream().forEach(System.out::println);
    }

    private static List<Integer> getDuplicateIntegersList(List<Integer> integerList) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        integerList.stream().forEach( integer -> {
            if(!set.contains(integer)){
                set.add(integer);
            } else {
                list.add(integer);
            }
        });
        return list;
    }
}
