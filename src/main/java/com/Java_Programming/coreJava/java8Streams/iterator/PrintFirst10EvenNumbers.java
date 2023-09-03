package com.Java_Programming.coreJava.java8Streams.iterator;

import java.util.stream.Stream;

public class PrintFirst10EvenNumbers {
    public static void main(String[] args) {
        Stream.iterate(1, element -> element + 1)
                .filter(element -> element % 2 == 0)
                .limit(5)
                .forEach(System.out::println);
    }
}
