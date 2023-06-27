package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class LeftHalfPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in) ;
        int line  = sc.nextInt() ;
        printLeftHalfPyramid(line);
    }
    public static void printLeftHalfPyramid ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
             for ( int j = 1 ; j <= line - i ; j++ ){
                 System.out.print("  ");
             }
             for ( int j = 1 ; j <= i ; j++ ){
                 System.out.print("* ");
             }
            System.out.println();
        }
    }
}
