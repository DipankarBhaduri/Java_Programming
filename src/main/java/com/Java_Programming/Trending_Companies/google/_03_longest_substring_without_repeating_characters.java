package com.Java_Programming.Trending_Companies.google;

import java.util.HashSet;

public class _03_longest_substring_without_repeating_characters {
    /**
     * @Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */

    public static void main(String[] args) {
        /**
         * @Example :
         * Example 1:
         *
         * Input: s = "abcabcbb"
         * Output: 3
         * Explanation: The answer is "abc", with the length of 3.
         * Example 2:
         *
         * Input: s = "bbbbb"
         * Output: 1
         * Explanation: The answer is "b", with the length of 1.
         */

        String s = "abac";
        int maxSubStringLength = lengthOfLongestSubstring(s);
        System.out.println("The max length of substring without repeating character is : "+maxSubStringLength);
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        HashSet<Character> set = new HashSet<>();

        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            } else {
                set.remove(s.charAt(start++));
            }
            maxLength = set.size();
        }
        return maxLength;
    }
}
