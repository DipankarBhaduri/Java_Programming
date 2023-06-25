package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class NumberChangingPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int line = sc.nextInt() ;
        printNumberChangingPyramid(line);
    }
    public static void printNumberChangingPyramid ( int line ){
        int count = 1 ;
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 1 ; j <= i ; j++ ){
                System.out.print(count++ +" ");
            }
            System.out.println();
        }
    }
}
