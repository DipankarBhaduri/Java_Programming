package com.Java_Programming.coreJava.java8Streams.practiceProblem_04_09_2023;

import java.util.Arrays;
import java.util.List;

public class ProductOffAllIntegers {
    /**
     * @Questions : Calculate the product of all integers in a list using the reduce operation
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4);
        int product = getProductValueOfList (list);
        System.out.println(product);
    }

    public static int getProductValueOfList (List<Integer> integerList) {
        return integerList.stream().reduce(1, (num1, num2) -> num1 * num2);
    }
}
