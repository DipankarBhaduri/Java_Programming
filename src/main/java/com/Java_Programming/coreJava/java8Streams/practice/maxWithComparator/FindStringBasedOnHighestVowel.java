package com.Java_Programming.coreJava.java8Streams.practice.maxWithComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindStringBasedOnHighestVowel {
    /**
     * @Questions Given a list of words, use the Stream API to find the word with the highest number of vowels.
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Dipankar", "Pritam", "Ajay", "Shuklaaaaaa");
        String mostVowelContainsList = getMostVowelContainsString (stringList);
        System.out.println(mostVowelContainsList);
    }

    private static String getMostVowelContainsString(List<String> stringList) {
        return stringList.stream().max(Comparator.comparingInt(string -> countVowels((String)string))).get();
    }

    /**
     * @param word : In word passing a string
     * @return returning the count of vowels in the word
     */
    public static int countVowels(String word) {
        return (int) word.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> "AEIOUaeiou".contains(String.valueOf(ch)))
                .count();
    }
}

