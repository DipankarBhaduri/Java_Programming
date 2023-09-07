package com.Java_Programming.learning.alpha._11_patternBasic;

import java.util.Scanner;

public class ButterFlyPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in) ;
        int line = sc.nextInt() ;
        printButterFlyPattern(line);
    }
    public static void printButterFlyPattern ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 1 ; j <= 2 * line - 1  ; j++ ){
                if( j >= i && j <= 2*line - i ){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        for ( int i = 1 ; i <= 2 * line - 1 ; i++ ){
            System.out.print("*");
        }
        System.out.println();

        for ( int i = line ; i >= 1 ;  i-- ){
            for ( int j = 1 ; j <= 2 * line - 1  ; j++ ){
                if( j >= i && j <= 2*line - i ){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
