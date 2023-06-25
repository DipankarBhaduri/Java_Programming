package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class NumberIncressingPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in) ;
        int line = sc.nextInt() ;
        printNumberIncressingPyramid(line);
    }

    public static void printNumberIncressingPyramid ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 1  ; j <= i ; j++ ){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
