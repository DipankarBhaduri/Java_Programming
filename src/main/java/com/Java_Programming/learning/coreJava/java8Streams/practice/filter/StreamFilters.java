package com.Java_Programming.learning.coreJava.java8Streams.practice.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilters {
    public static void main(String[] args) {
        List<String> names =Arrays.asList("Pritam", "abcd", "Soubhik", "ghijkl", "Gourav", "pritm", "Mamata");

        System.out.println("---------- Starts with 'P' -----------");
        List<String> filterdNames = filterListByStartsWithCharacter(names, 'P');
        filterdNames.stream().forEach(System.out::println);

        System.out.println("---------- Starts or End with 'M' -----------");
        filterdNames = filterListByStartsOrEndByCharacter(names, 'M');
        filterdNames.stream().forEach(System.out::println);

        System.out.println("---------- Starts or End with 'M' not a case sensitive -----------");
        filterdNames = filterListByStartsOrEndByCharacterWithOutCaseSensitive(names, 'm');
        filterdNames.stream().forEach(System.out::println);

        System.out.println("---------- Contains vowel more than one -----------");
        filterdNames = containsVowelMoreThanOnes(names, Arrays.asList("a", "e", "i", "o", "u"));
        filterdNames.stream().forEach(System.out::println);

        System.out.println("---------- Filter Even numbers -----------");
        List<Integer> evenNumbers = filterEvenNumbers (Arrays.asList(0, 2, 3, 4, 5, 6, 7, 8, 4, 5, 4));
        evenNumbers.stream().forEach(System.out::println);
    }


    /**
     * @param names : List of String is presents in names
     * @param ch : Only single character passing through arguments
     * @return : those list where starts with the character
     */
    public static List<String> filterListByStartsWithCharacter (List<String> names, char ch) {
        return names.stream()
                .filter(name -> name.startsWith(String.valueOf(ch)))
                .collect(Collectors.toList());
    }


    /**
     * @param names : List of String is presents in names
     * @param ch : Only single character passing through arguments
     * @return : those list where starts or ends with the character
     */
    public static List<String> filterListByStartsOrEndByCharacter (List<String> names, char ch) {
        return names.stream()
                .filter(name -> (name.startsWith(String.valueOf(ch)) || name.endsWith(String.valueOf(ch))))
                .collect(Collectors.toList());
    }


    /**
     * @param names : List of String is presents in names
     * @param ch : Only single character passing through arguments
     * @return : those list where starts or ends with the character without case-sensitive
     */
    public static List<String> filterListByStartsOrEndByCharacterWithOutCaseSensitive (List<String> names, char ch) {
        return names.stream()
                .filter(name -> (name.startsWith(String.valueOf(ch).toLowerCase()) || name.startsWith(String.valueOf(ch).toUpperCase()) ||
                        name.startsWith(String.valueOf(ch).toLowerCase()) || name.endsWith(String.valueOf(ch).toLowerCase())))
                .collect(Collectors.toList());
    }


    /**
     * @param names : List of String is presents in names
     * @return : those list where contains vowel more than one
     */
    public static List<String> containsVowelMoreThanOnes (List<String> names, List<String> vowels) {
        return names.stream()
                .filter(name ->
                        vowels.stream().filter(vowel -> name.contains(vowel)).count()>1).collect(Collectors.toList());
    }


    /**
     * @param numbers : As an input parameter List of Integers I am taking;
     * @return : List of even Numbers
     */
    public static List<Integer> filterEvenNumbers (List<Integer> numbers) {
        return numbers.stream().filter(number -> (number%2) == 0).collect(Collectors.toList());
    }
}
