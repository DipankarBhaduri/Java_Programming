package com.Java_Programming.coreJava.java8Streams.practiceProblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductOfAllIntegers {
    /**
     * @Question Reducing with an Initial Value: Calculate the product of all integers
     * in a list using reduce with an initial value.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList( 2,3,4,5,7,6,8,9);
        int product = calculateTheProductOfAllIntegers (integerList);
        System.out.println(product);
    }

    private static int calculateTheProductOfAllIntegers(List<Integer> integerList) {
        return integerList.stream().reduce(1, (num1,num2) -> num1 * num2);
    }
}
