package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class TriangleStarPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int line = sc.nextInt() ;
        printTriangleStarPattern(line);
    }
    public static void printTriangleStarPattern ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 1 ; j <= line - i ; j++ ){
                System.out.print(" ");
            }
            for ( int j = 1 ; j <= i ; j++ ){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
