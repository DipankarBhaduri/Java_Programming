package com.Java_Programming.learning.trendingCompanies.google;

public class _09_palindrome_number {
    /**
     * @Link : https://leetcode.com/problems/palindrome-number/
     */
    public static void main(String[] args) {
        int input1 = 121;
        int input2 = -121;
        boolean result = isPalindrome(input1);
        System.out.println(result);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int previous = x;
            int reverse = doReverse(x);
            return (previous == reverse);
        }
    }

    public static int doReverse(int x) {
         int rem = 0;
         int rev = 0;
         while (x > 0) {
             rem = x % 10;
             rev = rev * 10 + rem;
             x = x / 10;
         }
         return rev;
    }
}
