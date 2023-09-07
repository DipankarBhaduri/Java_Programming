package com.Java_Programming.learning.alpha._11_patternBasic;

import java.util.Scanner;

public class NumberIncressingReversePyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int line = sc.nextInt() ;
        printNumberIncressingReversePyramid(line);
    }
    public static void printNumberIncressingReversePyramid ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 1 ; j <= line - i + 1 ; j++ ){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
