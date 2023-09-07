package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_06_09_2023;

import java.util.OptionalLong;
import java.util.stream.LongStream;

public class CalculateFactroialOfANumber {
    /**
     * @Questions : Write a program to calculate the factorial of a given number using the Stream API
     * @param args
     */
    public static void main(String[] args) {
        OptionalLong response = getFactorialValue(5);
        System.out.println(response);
    }

    private static OptionalLong getFactorialValue(int num) {
        return LongStream.rangeClosed(2,num)
                .reduce((a,b) -> a*b);
    }
}
