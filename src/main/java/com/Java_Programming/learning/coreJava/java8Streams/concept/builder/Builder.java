package com.Java_Programming.learning.coreJava.java8Streams.concept.builder;

import java.util.stream.Stream;

public class Builder {
    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> stream = builder.add("Ram").add("Syam").add("Jodu").build();
        stream.forEach(System.out::println);
    }
}
