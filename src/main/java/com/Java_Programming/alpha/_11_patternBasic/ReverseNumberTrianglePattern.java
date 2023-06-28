package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class ReverseNumberTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in) ;
        int line = sc.nextInt() ;
        printReverseNumberTrianglePattern(line);
    }
    public static void printReverseNumberTrianglePattern ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 2 ; j <= i ; j++){
                System.out.print(" ");
            }
            for ( int j = i ; j <= line ; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
