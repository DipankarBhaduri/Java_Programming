package com.Java_Programming.learning.alpha._11_patternBasic;

import java.util.Scanner;

public class RightHalfPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in) ;
        int line  = sc.nextInt() ;
        printRightHalfPyramid(line);
    }
    public static void printRightHalfPyramid ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 1 ; j <= i ; j++ ){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
