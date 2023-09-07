package com.Java_Programming.learning.coreJava.java8Streams.concept.count;

import java.util.Arrays;
import java.util.List;

public class Count {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2, 4, 5, 6, 7, 8);
        int count = countEvenNumbers (integerList);
        System.out.println(count);
    }

    private static int countEvenNumbers(List<Integer> integerList) {
        return (int) integerList.stream().filter(num -> num % 2 == 0).count();
    }
}