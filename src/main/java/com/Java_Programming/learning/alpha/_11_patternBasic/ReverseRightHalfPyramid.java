package com.Java_Programming.learning.alpha._11_patternBasic;

import java.util.Scanner;

public class ReverseRightHalfPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in) ;
        int line  = sc.nextInt() ;
        printReverseRightHalfPyramid(line);
    }
    public static void printReverseRightHalfPyramid ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = line ; j >= i ; j-- ){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
