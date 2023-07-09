package com.Java_Programming.alpha._17_strings;

import java.util.Scanner;

public class IfStringIsPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;

        String str = "racecare" ;
        System.out.println(str);
        boolean response = checkIfStringIsPalindrome(str) ;
        System.out.println(response);
    }

    public static boolean checkIfStringIsPalindrome ( String str ){
        char [] ch = str.toCharArray() ;
        int start = 0 ;
        int end = ch.length - 1 ;
        for ( int i = 0 ; i < ch.length / 2 ; i++ ){
            char ch1 = ch[start++] ;
            char ch2 = ch[end--] ;
            if ( ch1 != ch2 ){
                return false ;
            }
        }
        return true ;
    }
}
