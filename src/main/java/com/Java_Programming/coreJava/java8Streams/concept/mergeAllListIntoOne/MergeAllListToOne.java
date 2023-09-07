package com.Java_Programming.coreJava.java8Streams.concept.mergeAllListIntoOne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeAllListToOne {
    public static void main(String[] args) {
        List<Integer> integerList1 = Arrays.asList(2, 3, 4);
        List<Integer> integerList2 = Arrays.asList(4, 5, 6);
        List<Integer> integerList3 = Arrays.asList(7, 8, 9);
        List<List<Integer>> listOfList = Arrays.asList(integerList1, integerList2, integerList3);

        List<Integer> mergedList = mergeAllListOfIntegerUsingFlatMap (listOfList);
        mergedList.stream().forEach(System.out::println);
    }

    private static List<Integer> mergeAllListOfIntegerUsingFlatMap(List<List<Integer>> listOfList) {
        return listOfList.stream()
                .flatMap( integerList -> integerList
                        .stream()
                        .flatMap( i -> Stream.of(i)))
                .distinct()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
    }
}
