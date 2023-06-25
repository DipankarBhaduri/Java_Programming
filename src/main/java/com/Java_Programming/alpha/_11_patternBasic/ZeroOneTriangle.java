package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class ZeroOneTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int line = sc.nextInt();
        printZeroOneTriangle(line);
    }
    public static void printZeroOneTriangle ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            int printer = 0 ;
            if ( i % 2 != 0 ){
                printer = 1 ;
            } else {
                printer = 0 ;
            }

            for ( int j = 1 ; j <= i ; j++ ){
                System.out.print(printer+" ");
                printer = printer == 1 ? 0 : 1 ;
            }

            System.out.println();
        }
    }
}
