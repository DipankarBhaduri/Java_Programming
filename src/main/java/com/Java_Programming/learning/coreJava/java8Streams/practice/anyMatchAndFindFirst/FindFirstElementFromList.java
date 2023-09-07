package com.Java_Programming.learning.coreJava.java8Streams.practice.anyMatchAndFindFirst;

import java.util.Arrays;
import java.util.List;

public class FindFirstElementFromList {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Dipan", "Dipak", "Pritam", "Subhas");
        String ans = findFirstString(stringList);
        System.out.println(ans);

        Boolean response = getAnyMatchResponse (stringList);
        System.out.println(response);
    }

    private static Boolean getAnyMatchResponse(List<String> stringList) {
        return stringList.stream().anyMatch(s-> s.startsWith("DipankarB"));
    }

    private static String findFirstString(List<String> stringList) {
        return stringList.stream().filter(s-> s.contains("pa")).findFirst().get();
    }
}
