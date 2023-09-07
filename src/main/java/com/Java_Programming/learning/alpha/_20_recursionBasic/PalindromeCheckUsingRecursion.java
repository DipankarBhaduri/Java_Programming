package com.Java_Programming.learning.alpha._20_recursionBasic;

public class PalindromeCheckUsingRecursion {
    public static void main(String[] args) {
        String str = "racecar" ;
        boolean response = checkPalindromeCheckUsingRecursion(str) ;
        System.out.println(response);
    }
    public static boolean checkPalindromeCheckUsingRecursion ( String str ){
        if ( str.length() < 2 ){
            return true ;
        }
        if ( str.charAt(0) != str.charAt(str.length() - 1 )){
            return false ;
        } else {
            return true && checkPalindromeCheckUsingRecursion(str.substring(1 ,str.length()-1)) ;
        }
    }
}
