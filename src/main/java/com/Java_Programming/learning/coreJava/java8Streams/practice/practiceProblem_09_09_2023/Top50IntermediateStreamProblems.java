package com.Java_Programming.learning.coreJava.java8Streams.practice.practiceProblem_09_09_2023;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;
import java.util.stream.Collectors;

public class Top50IntermediateStreamProblems {
    /**
     * @Questions :
     * Given a list of employees, find the top N earners using a stream.
     * Filter a list of strings to keep only those that contain both vowels and consonants.
     * Given a list of tasks with due dates, find the tasks that are overdue using a stream.
     * Write a stream to find the longest subsequence of increasing integers in a list.
     * Given a list of words, find the most frequent letter using a stream.
     * Filter a list of integers to keep only those that are prime palindromes.
     * Given a list of transactions, find the total profit for each category using a stream.
     * Use a stream to generate all possible subsets of a set.
     * Given a list of students, find the student with the highest GPA in each department using a stream.
     * Filter a list of strings to keep only those that are valid URLs.
     * Given a list of dates, find the day of the week that occurs most frequently using a stream.
     * Use a stream to find the longest increasing subarray in a list of integers.
     * Given a list of products, find the most expensive product in each category using a stream.
     * Filter a list of integers to keep only those that are part of a Fibonacci sequence.
     * Given a list of emails, find the domain with the most registered users using a stream.
     * Use a stream to generate all possible permutations of a string.
     * Given a list of movies, find the top N highest-grossing movies using a stream.
     * Filter a list of strings to keep only those that are valid phone numbers.
     * Given a list of transactions, find the category with the highest total profit using a stream.
     * Use a stream to find the longest common prefix among a list of strings.
     * Given a list of integers, find the contiguous subarray with the largest sum using a stream.
     * Filter a list of strings to keep only those that are valid IP addresses.
     * Given a list of students, find the department with the highest average GPA using a stream.
     * Use a stream to find the first non-repeating character in a string.
     * Given a list of words, find the anagram group with the most words using a stream.
     * Filter a list of integers to keep only those that are palindromic primes.
     * Given a list of transactions, find the category with the highest average profit using a stream.
     * Use a stream to find the maximum number of consecutive zeros in a binary string.
     * Given a list of employees, find the department with the most employees using a stream.
     * Filter a list of strings to keep only those that are valid XML documents.
     * Given a list of dates, find the month with the most occurrences of a specific day of the week using a stream.
     * Use a stream to find the shortest path between two nodes in a graph represented as a list of edges.
     * Given a list of products, find the top N products with the most sales using a stream.
     * Filter a list of integers to keep only those that are palindromic squares.
     * Given a list of emails, find the provider with the most unique users using a stream.
     * Use a stream to calculate the Levenshtein distance between two strings.
     * Given a list of words, find the shortest substring that contains all vowels using a stream.
     * Filter a list of integers to keep only those that are part of a geometric sequence.
     * Given a list of transactions, find the top N categories with the highest average profit using a stream.
     * Use a stream to find the shortest path in a weighted graph represented as an adjacency matrix.
     * Given a list of employees, find the department with the highest average salary using a stream.
     * @param args
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "racecar",
                "deifi",
                "hello",
                "level",
                "world",
                "civic",
                "radar",
                "apple",
                "rotor",
                "java",
                "moon",
                "noon",
                "madam-madam"
        );

        String longestPalindrome = findLongestPalindromic(words);
        System.out.println(longestPalindrome);
    }

    /**--------------------------------------------------------------------------------
     * @Question : Given a list of words, find the longest palindrome using a stream.
     * @param words
     * @return
     */
    private static String findLongestPalindromic ( List<String> words){
        return words.stream()
                .filter(word -> checkPalindrome(word))
                .max((word1, word2) -> word1.length() > word2.length() ? 1 : -1)
                .get();
    }

    private static boolean checkPalindrome (String string){
        if(string.length() == 0 || string.length() ==1){
            return true;
        }

        if(string.charAt(0) == string.charAt(string.length()-1)){
            return checkPalindrome(string.substring(1,string.length()-1));
        }else{
            return false;
        }
    }

    /**-----------------------------------------------------------------------------------
     * @Questions : Filter a list of integers to keep only those that are perfect squares.
     * @param integerList
     * @return
     */
    private static List<Integer> getPerfectSquareIntegerList(List<Integer> integerList) {
        return integerList.stream()
                .filter(integer -> (Math.sqrt(integer) % 1 == 0))
                .collect(Collectors.toList());
    }

    /**---------------------------------------------------------------------------------------
     * @Questions : Given a list of books, find the book with the highest rating using a stream.
     * @param books
     * @return
     */
    private static Book findBookByRating (List<Book> books){
        return books.stream()
                .min((num1, num2) -> num1.getRating() > num2.getRating() ? 1 : -1)
                .get();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Book {
        private String title;
        private String author;
        private double rating;
    }

    /**----------------------------------------------------------------------------------------
     * @Questions : Given a list of transactions, find the total profit for each year using a stream
     * @param transactions
     * @return
     */
    private static Map<Integer, Double> getTotalProfit(List<Transaction> transactions){
        Map<Integer, Double> map = new HashMap<>();
        transactions.stream().forEach(transaction -> {
                if(!map.containsKey(transaction.getYear())){
                    map.put(transaction.getYear(), transaction.getProfit());
                }else{
                    map.put(transaction.getYear(), transaction.getYear()+map.get(transaction.getYear()));
                }
        });
        return map;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Transaction {
        private int year;
        private double profit;
    }

    /**-------------------------------------------------------------------------------------
     * @Questions : Filter a list of strings to keep only those that are valid email addresses.
     * @param emailList
     * @return
     */
    private static List<String> getValidEmailAddress (List<String> emailList) {
        return emailList.stream()
                .filter(email -> email.contains("@") && email.contains(".") && !email.contains(" "))
                .collect(Collectors.toList());
    }

    /** --------------------------------------------------------------------
     * @Question : Given a list of integers, find the median using a stream.
     * @param integerList
     * @return
     */
    private static LongSummaryStatistics calculateMedian(List<Integer> integerList) {
        return integerList.stream().collect(Collectors.summarizingLong(Integer::intValue));
    }
}
