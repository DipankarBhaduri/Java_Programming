package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class RhombusPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in) ;
        int line = sc.nextInt() ;
        printRhombusPattern(line);
    }
    public static void printRhombusPattern ( int line ){
        for ( int i = 1 ; i <= line + line / 2 ; i++ ){
            for ( int j = 1 ; j <= i ; j++ ){
                System.out.print(" ");
            }
            for ( int j = 1 ; j <= line ; j++ ){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
