package com.Java_Programming.learning.alpha._11_patternBasic;

import java.util.Scanner ;

public class PalindromeTriangular {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in) ;
        int line = sc.nextInt() ;
        printPalindromeTriangular(line) ;
    }
    public static void printPalindromeTriangular ( int line ){
        for ( int i = 1  ; i <= line ; i++ ){
            for ( int j = 1 ; j <= line - i ; j++ ){
                System.out.print("  ") ;
            }
            for ( int j = i ; j >= 1 ; j--){
                System.out.print(j+" ") ;
            }
            if ( i > 1) {
                for ( int j = 2 ; j <= i ; j++ ){
                    System.out.print(j+" ") ;
                }
            }
            System.out.println() ;
        }
    }
}