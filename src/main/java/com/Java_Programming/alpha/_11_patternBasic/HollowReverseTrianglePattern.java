package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class HollowReverseTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in) ;
        int line = sc.nextInt() ;
        printHollowReverseTrianglePattern(line);
    }
    public static void printHollowReverseTrianglePattern ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 2 ; j <= i ; j++ ){
                System.out.print(" ");
            }
            for ( int j = 1 ; j <= 2 * line - 1 ; j++ ){
                if ( i == 1 || j == 1 || j == 2*line - 2*i + 1 ){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
