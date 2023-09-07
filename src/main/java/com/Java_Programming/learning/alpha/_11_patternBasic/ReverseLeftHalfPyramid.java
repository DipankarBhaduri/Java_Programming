package com.Java_Programming.learning.alpha._11_patternBasic;

import java.util.Scanner;

public class ReverseLeftHalfPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int line = sc.nextInt() ;
        printReverseLeftHalfPyramid(line);
    }
    public static void printReverseLeftHalfPyramid ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 2 ; j <= i ; j++ ){
                System.out.print("  ");
            }
            for ( int j = 1 ; j <= line - i + 1 ; j++ ){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
