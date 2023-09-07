package com.Java_Programming.learning.alpha._11_patternBasic;

import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int line = sc.nextInt() ;
        printDiamondPattern(line);
    }
    public static void printDiamondPattern ( int line ){
        for ( int i = 1 ; i <= line / 2 + 1 ; i++ ){
            for ( int j = 1 ; j <= line / 2 - i + 1  ; j++ ){
                System.out.print(" ");
            }
            for ( int j = 1 ; j <= i ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for ( int i = line / 2  ; i >= 1 ; i-- ){
            for ( int j = 1 ; j <= line / 2 - i  + 1 ; j++ ){
                System.out.print(" ");
            }
            for ( int j = 1 ; j <= i ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
